package cn.cactus.module.system.api.dict.dto;

import cn.cactus.framework.common.enums.CommonStatusEnum;
import lombok.Data;

/**
 * Package: cn.cactus.module.system.api.dict.dto
 * Description:
 * 字典数据 Response DTO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 10:02
 * @Github https://github.com/lixuanfengs
 */
@Data
public class DictDataRespDTO {

    /**
     * 字典标签
     */
    private String label;
    /**
     * 字典值
     */
    private String value;
    /**
     * 字典类型
     */
    private String dictType;
    /**
     * 状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;
}
