package cn.cactus.module.system.api.errorcode.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.system.api.errorcode.dto
 * Description:
 * 错误码自动生成 DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:13
 * @Github https://github.com/lixuanfengs
 */
@Data
@Accessors(chain = true)
public class ErrorCodeAutoGenerateReqDTO {

    /**
     * 应用名
     */
    @NotNull(message = "应用名不能为空")
    private String applicationName;
    /**
     * 错误码编码
     */
    @NotNull(message = "错误码编码不能为空")
    private Integer code;
    /**
     * 错误码错误提示
     */
    @NotEmpty(message = "错误码错误提示不能为空")
    private String message;

}