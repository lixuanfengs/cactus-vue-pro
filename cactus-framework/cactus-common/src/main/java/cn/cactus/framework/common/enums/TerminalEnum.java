package cn.cactus.framework.common.enums;

import cn.cactus.framework.common.core.IntArrayValuable;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * Package: cn.cactus.framework.common.enums
 * Description:
 *  终端的枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/9 9:45
 * @Github https://github.com/lixuanfengs
 */
@RequiredArgsConstructor
@Getter
public enum TerminalEnum implements IntArrayValuable {

    WECHAT_MINI_PROGRAM(10, "微信小程序"),
    WECHAT_WAP(11, "微信公众号"),
    H5(20, "H5 网页"),
    APP(31, "手机 App"),
    ;

    public static final int[] ARRAYS = Arrays.stream(values()).mapToInt(TerminalEnum::getTerminal).toArray();

    /**
     * 终端
     */
    private final Integer terminal;
    /**
     * 终端名
     */
    private final String name;

    @Override
    public int[] array() {
        return ARRAYS;
    }
}
