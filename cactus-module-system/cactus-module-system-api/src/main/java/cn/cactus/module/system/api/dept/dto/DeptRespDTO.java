package cn.cactus.module.system.api.dept.dto;

import cn.cactus.framework.common.enums.CommonStatusEnum;
import lombok.Data;

/**
 * Package: cn.cactus.module.system.api.dept.dto
 * Description:
 * 部门 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:10
 * @Github https://github.com/lixuanfengs
 */
@Data
public class DeptRespDTO {

    /**
     * 部门编号
     */
    private Long id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门编号
     */
    private Long parentId;
    /**
     * 负责人的用户编号
     */
    private Long leaderUserId;
    /**
     * 部门状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

}
