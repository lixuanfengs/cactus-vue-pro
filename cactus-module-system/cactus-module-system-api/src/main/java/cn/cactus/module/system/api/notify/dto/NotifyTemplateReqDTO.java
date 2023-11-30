package cn.cactus.module.system.api.notify.dto;

import cn.cactus.framework.common.enums.CommonStatusEnum;
import cn.cactus.framework.common.validation.InEnum;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.api.notify.dto
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:20
 * @Github https://github.com/lixuanfengs
 */
@Data
public class NotifyTemplateReqDTO {

    @NotEmpty(message = "模版名称不能为空")
    private String name;

    @NotNull(message = "模版编码不能为空")
    private String code;

    @NotNull(message = "模版类型不能为空")
    private Integer type;

    @NotEmpty(message = "发送人名称不能为空")
    private String nickname;

    @NotEmpty(message = "模版内容不能为空")
    private String content;

    @NotNull(message = "状态不能为空")
    @InEnum(value = CommonStatusEnum.class, message = "状态必须是 {value}")
    private Integer status;

    private String remark;

}
