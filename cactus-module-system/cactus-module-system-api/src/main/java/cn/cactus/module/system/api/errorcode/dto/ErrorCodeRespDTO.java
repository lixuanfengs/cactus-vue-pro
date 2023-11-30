package cn.cactus.module.system.api.errorcode.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.system.api.errorcode.dto
 * Description:
 * 错误码的 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:15
 * @Github https://github.com/lixuanfengs
 */
@Data
public class ErrorCodeRespDTO {

    /**
     * 错误码编码
     */
    private Integer code;
    /**
     * 错误码错误提示
     */
    private String message;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

}
