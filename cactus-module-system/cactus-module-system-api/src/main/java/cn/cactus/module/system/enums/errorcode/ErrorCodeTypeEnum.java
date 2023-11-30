package cn.cactus.module.system.enums.errorcode;

import cn.cactus.framework.common.core.IntArrayValuable;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

/**
 * Package: cn.cactus.module.system.enums.errorcode
 * Description:
 * 错误码的类型枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 11:05
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
@Getter
public enum ErrorCodeTypeEnum implements IntArrayValuable {

    /**
     * 自动生成
     */
    AUTO_GENERATION(1),
    /**
     * 手动编辑
     */
    MANUAL_OPERATION(2);

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(ErrorCodeTypeEnum::getType).toArray();

    /**
     * 类型
     */
    private final Integer type;

    @Override
    public int[] array() {
        return ARRAYS;
    }

}

