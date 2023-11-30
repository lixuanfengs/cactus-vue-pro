package cn.cactus.framework.ip.core.enums;

import cn.cactus.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Package: cn.cactus.framework.ip.core.enums
 * Description:
 * 区域类型枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:52
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
@Getter
public enum AreaTypeEnum implements IntArrayValuable {

    COUNTRY(1, "国家"),
    PROVINCE(2, "省份"),
    CITY(3, "城市"),
    DISTRICT(4, "地区"), // 县、镇、区等
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(AreaTypeEnum::getType).toArray();

    /**
     * 类型
     */
    private final Integer type;
    /**
     * 名字
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }
}

