package cn.cactus.module.system.service.permission.bo;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Package: cn.cactus.module.system.service.permission.bo
 * Description:
 * 角色创建 Request BO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 15:54
 * @Github https://github.com/lixuanfengs
 */
@Data
public class RoleCreateReqBO {

    /**
     * 角色名称
     */
    @NotBlank(message = "角色名称不能为空")
    @Size(max = 30, message = "角色名称长度不能超过30个字符")
    private String name;

    /**
     * 角色标志
     */
    @NotBlank(message = "角色标志不能为空")
    @Size(max = 100, message = "角色标志长度不能超过100个字符")
    private String code;

    /**
     * 显示顺序
     */
    @NotNull(message = "显示顺序不能为空")
    private Integer sort;

    /**
     * 角色类型
     */
    @NotNull(message = "角色类型不能为空")
    private Integer type;

}