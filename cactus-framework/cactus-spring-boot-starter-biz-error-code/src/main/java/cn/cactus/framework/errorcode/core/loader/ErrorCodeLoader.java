package cn.cactus.framework.errorcode.core.loader;

import cn.cactus.framework.common.exception.util.ServiceExceptionUtil;

/**
 * Package: cn.cactus.framework.errorcode.core.loader
 * Description:
 * 错误码加载器
 *
 * 注意，错误码最终加载到 {@link ServiceExceptionUtil} 的 MESSAGES 变量中！
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:18
 * @Github https://github.com/lixuanfengs
 */
public interface ErrorCodeLoader {

    /**
     * 添加错误码
     *
     * @param code 错误码的编号
     * @param msg 错误码的提示
     */
    default void putErrorCode(Integer code, String msg) {
        ServiceExceptionUtil.put(code, msg);
    }

}
