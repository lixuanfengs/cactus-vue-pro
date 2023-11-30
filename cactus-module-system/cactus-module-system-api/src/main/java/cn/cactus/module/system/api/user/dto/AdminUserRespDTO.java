package cn.cactus.module.system.api.user.dto;

import cn.cactus.framework.common.enums.CommonStatusEnum;
import lombok.Data;

import java.util.Set;

/**
 * Package: cn.cactus.module.system.api.user.dto
 * Description:
 * Admin 用户 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:46
 * @Github https://github.com/lixuanfengs
 */
@Data
public class AdminUserRespDTO {

    /**
     * 用户ID
     */
    private Long id;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 帐号状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 岗位编号数组
     */
    private Set<Long> postIds;
    /**
     * 手机号码
     */
    private String mobile;

}
