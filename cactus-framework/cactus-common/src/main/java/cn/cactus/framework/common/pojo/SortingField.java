package cn.cactus.framework.common.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Package: cn.cactus.framework.common.pojo
 * Description:
 *
 * 排序字段 DTO
 *
 * 类名加了 ing 的原因是，避免和 ES SortField 重名。
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/9 11:02
 * @Github https://github.com/lixuanfengs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SortingField implements Serializable {

    /**
     * 顺序 - 升序
     */
    public static final String ORDER_ASC = "asc";
    /**
     * 顺序 - 降序
     */
    public static final String ORDER_DESC = "desc";

    /**
     * 字段
     */
    private String field;
    /**
     * 顺序
     */
    private String order;

}
