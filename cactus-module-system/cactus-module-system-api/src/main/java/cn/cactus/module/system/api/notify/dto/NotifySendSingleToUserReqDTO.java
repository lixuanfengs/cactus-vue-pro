package cn.cactus.module.system.api.notify.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Map;

/**
 * Package: cn.cactus.module.system.api.notify.dto
 * Description:
 * 站内信发送给 Admin 或者 Member 用户
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:19
 * @Github https://github.com/lixuanfengs
 */
@Data
public class NotifySendSingleToUserReqDTO {

    /**
     * 用户编号
     */
    @NotNull(message = "用户编号不能为空")
    private Long userId;

    /**
     * 站内信模板编号
     */
    @NotEmpty(message = "站内信模板编号不能为空")
    private String templateCode;

    /**
     * 站内信模板参数
     */
    private Map<String, Object> templateParams;

}
