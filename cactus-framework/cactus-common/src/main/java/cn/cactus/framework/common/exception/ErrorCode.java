package cn.cactus.framework.common.exception;

import cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants;
import cn.cactus.framework.common.exception.enums.ServiceErrorCodeRange;
import lombok.Data;

/**
 * Package: cn.cactus.framework.common.exception
 * Description:
 *  错误码对象
 *      全局错误码，占用 [0, 999], 参见 {@link GlobalErrorCodeConstants}
 *      业务异常错误码，占用 [1 000 000 000, +∞)，参见 {@link ServiceErrorCodeRange}
 *
 *  TODO 错误码设计成对象的原因，为未来的 i18 国际化做准备
 *
 * @Date 2023/11/9 9:50
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/9 9:50
 * @Github https://github.com/lixuanfengs
 */
@Data
public class ErrorCode {

    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }
}
