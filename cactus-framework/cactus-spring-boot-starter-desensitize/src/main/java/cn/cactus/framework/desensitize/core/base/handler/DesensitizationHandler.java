package cn.cactus.framework.desensitize.core.base.handler;

import java.lang.annotation.Annotation;

/**
 * Package: cn.cactus.framework.desensitize.core.base.handler
 * Description:
 * 脱敏处理器接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:48
 * @Github https://github.com/lixuanfengs
 */
public interface DesensitizationHandler<T extends Annotation> {

    /**
     * 脱敏
     *
     * @param origin     原始字符串
     * @param annotation 注解信息
     * @return 脱敏后的字符串
     */
    String desensitize(String origin, T annotation);

}