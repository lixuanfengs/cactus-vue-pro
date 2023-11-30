package cn.cactus.module.system.api.sms.dto.send;

import cn.cactus.framework.common.validation.Mobile;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Map;

/**
 * Package: cn.cactus.module.system.api.sms.dto.send
 * Description:
 * 短信发送给 Admin 或者 Member 用户
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:24
 * @Github https://github.com/lixuanfengs
 */
@Data
public class SmsSendSingleToUserReqDTO {

    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 手机号
     */
    @Mobile
    private String mobile;
    /**
     * 短信模板编号
     */
    @NotEmpty(message = "短信模板编号不能为空")
    private String templateCode;
    /**
     * 短信模板参数
     */
    private Map<String, Object> templateParams;

}
