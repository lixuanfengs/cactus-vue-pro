package cn.cactus.module.system.api.dept.dto;

import cn.cactus.framework.common.enums.CommonStatusEnum;
import lombok.Data;

/**
 * Package: cn.cactus.module.system.api.dept.dto
 * Description:
 * 岗位 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/12/7 16:07
 * @Github https://github.com/lixuanfengs
 */
@Data
public class PostRespDTO {

    /**
     * 岗位序号
     */
    private Long id;
    /**
     * 岗位名称
     */
    private String name;
    /**
     * 岗位编码
     */
    private String code;
    /**
     * 岗位排序
     */
    private Integer sort;
    /**
     * 状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

}
