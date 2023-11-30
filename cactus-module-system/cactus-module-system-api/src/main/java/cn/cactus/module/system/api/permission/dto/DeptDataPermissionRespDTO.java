package cn.cactus.module.system.api.permission.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Package: cn.cactus.module.system.api.permission.dto
 * Description:
 * 部门的数据权限 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:59
 * @Github https://github.com/lixuanfengs
 */
@Data
public class DeptDataPermissionRespDTO {

    /**
     * 是否可查看全部数据
     */
    private Boolean all;
    /**
     * 是否可查看自己的数据
     */
    private Boolean self;
    /**
     * 可查看的部门编号数组
     */
    private Set<Long> deptIds;

    public DeptDataPermissionRespDTO() {
        this.all = false;
        this.self = false;
        this.deptIds = new HashSet<>();
    }

}
