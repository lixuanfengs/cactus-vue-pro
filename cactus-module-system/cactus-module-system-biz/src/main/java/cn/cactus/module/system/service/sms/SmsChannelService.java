package cn.cactus.module.system.service.sms;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.sms.core.client.SmsClient;
import cn.cactus.module.system.controller.admin.sms.vo.channel.SmsChannelCreateReqVO;
import cn.cactus.module.system.controller.admin.sms.vo.channel.SmsChannelPageReqVO;
import cn.cactus.module.system.controller.admin.sms.vo.channel.SmsChannelUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.sms.SmsChannelDO;

import javax.validation.Valid;
import java.util.List;

/**
 * Package: cn.cactus.module.system.service.sms
 * Description:
 * 短信渠道 Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:02
 * @Github https://github.com/lixuanfengs
 */
public interface SmsChannelService {

    /**
     * 创建短信渠道
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createSmsChannel(@Valid SmsChannelCreateReqVO createReqVO);

    /**
     * 更新短信渠道
     *
     * @param updateReqVO 更新信息
     */
    void updateSmsChannel(@Valid SmsChannelUpdateReqVO updateReqVO);

    /**
     * 删除短信渠道
     *
     * @param id 编号
     */
    void deleteSmsChannel(Long id);

    /**
     * 获得短信渠道
     *
     * @param id 编号
     * @return 短信渠道
     */
    SmsChannelDO getSmsChannel(Long id);

    /**
     * 获得所有短信渠道列表
     *
     * @return 短信渠道列表
     */
    List<SmsChannelDO> getSmsChannelList();

    /**
     * 获得短信渠道分页
     *
     * @param pageReqVO 分页查询
     * @return 短信渠道分页
     */
    PageResult<SmsChannelDO> getSmsChannelPage(SmsChannelPageReqVO pageReqVO);

    /**
     * 获得短信客户端
     *
     * @param id 编号
     * @return 短信客户端
     */
    SmsClient getSmsClient(Long id);

    /**
     * 获得短信客户端
     *
     * @param code 编码
     * @return 短信客户端
     */
    SmsClient getSmsClient(String code);

}

