package cn.cactus.module.system.service.notify;

import cn.cactus.framework.common.enums.CommonStatusEnum;
import cn.cactus.framework.common.enums.UserTypeEnum;
import cn.cactus.module.system.dal.dataobject.notify.NotifyTemplateDO;
import com.google.common.annotations.VisibleForTesting;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

import static cn.cactus.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.cactus.module.system.enums.ErrorCodeConstants.NOTICE_NOT_FOUND;
import static cn.cactus.module.system.enums.ErrorCodeConstants.NOTIFY_SEND_TEMPLATE_PARAM_MISS;

/**
 * Package: cn.cactus.module.system.service.notify
 * Description:
 * 站内信发送 Service 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 15:48
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
@Slf4j
public class NotifySendServiceImpl implements NotifySendService {

    @Resource
    private NotifyTemplateService notifyTemplateService;

    @Resource
    private NotifyMessageService notifyMessageService;

    @Override
    public Long sendSingleNotifyToAdmin(Long userId, String templateCode, Map<String, Object> templateParams) {
        return sendSingleNotify(userId, UserTypeEnum.ADMIN.getValue(), templateCode, templateParams);
    }

    @Override
    public Long sendSingleNotifyToMember(Long userId, String templateCode, Map<String, Object> templateParams) {
        return sendSingleNotify(userId, UserTypeEnum.MEMBER.getValue(), templateCode, templateParams);
    }

    @Override
    public Long sendSingleNotify(Long userId, Integer userType, String templateCode, Map<String, Object> templateParams) {
        // 校验模版
        NotifyTemplateDO template = validateNotifyTemplate(templateCode);
        if (Objects.equals(template.getStatus(), CommonStatusEnum.DISABLE.getStatus())) {
            log.info("[sendSingleNotify][模版({})已经关闭，无法给用户({}/{})发送]", templateCode, userId, userType);
            return null;
        }
        // 校验参数
        validateTemplateParams(template, templateParams);

        // 发送站内信
        String content = notifyTemplateService.formatNotifyTemplateContent(template.getContent(), templateParams);
        return notifyMessageService.createNotifyMessage(userId, userType, template, content, templateParams);
    }

    @VisibleForTesting
    public NotifyTemplateDO validateNotifyTemplate(String templateCode) {
        // 获得站内信模板。考虑到效率，从缓存中获取
        NotifyTemplateDO template = notifyTemplateService.getNotifyTemplateByCodeFromCache(templateCode);
        // 站内信模板不存在
        if (template == null) {
            throw exception(NOTICE_NOT_FOUND);
        }
        return template;
    }

    /**
     * 校验站内信模版参数是否确实
     *
     * @param template 邮箱模板
     * @param templateParams 参数列表
     */
    @VisibleForTesting
    public void validateTemplateParams(NotifyTemplateDO template, Map<String, Object> templateParams) {
        template.getParams().forEach(key -> {
            Object value = templateParams.get(key);
            if (value == null) {
                throw exception(NOTIFY_SEND_TEMPLATE_PARAM_MISS, key);
            }
        });
    }
}
