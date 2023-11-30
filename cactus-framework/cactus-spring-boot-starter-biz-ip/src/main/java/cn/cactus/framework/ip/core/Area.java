package cn.cactus.framework.ip.core;

import cn.cactus.framework.ip.core.enums.AreaTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Package: cn.cactus.framework.ip.core
 * Description:
 * 区域节点，包括国家、省份、城市、地区等信息
 *
 * 数据可见 resources/area.csv 文件
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:51
 * @Github https://github.com/lixuanfengs
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Area {

    /**
     * 编号 - 全球，即根目录
     */
    public static final Integer ID_GLOBAL = 0;
    /**
     * 编号 - 中国
     */
    public static final Integer ID_CHINA = 1;

    /**
     * 编号
     */
    private Integer id;
    /**
     * 名字
     */
    private String name;
    /**
     * 类型
     *
     * 枚举 {@link AreaTypeEnum}
     */
    private Integer type;

    /**
     * 父节点
     */
    private Area parent;
    /**
     * 子节点
     */
    private List<Area> children;

}
