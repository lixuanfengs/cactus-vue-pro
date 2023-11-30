package cn.cactus.framework.desensitize.core.regex.handler;

import cn.cactus.framework.desensitize.core.base.handler.DesensitizationHandler;

import java.lang.annotation.Annotation;

/**
 * Package: cn.cactus.framework.desensitize.core.regex.handler
 * Description:
 * 正则表达式脱敏处理器抽象类，已实现通用的方法
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 14:50
 * @Github https://github.com/lixuanfengs
 */
public abstract class AbstractRegexDesensitizationHandler<T extends Annotation>
        implements DesensitizationHandler<T> {

    @Override
    public String desensitize(String origin, T annotation) {
        String regex = getRegex(annotation);
        String replacer = getReplacer(annotation);
        return origin.replaceAll(regex, replacer);
    }

    /**
     * 获取注解上的 regex 参数
     *
     * @param annotation 注解信息
     * @return 正则表达式
     */
    abstract String getRegex(T annotation);

    /**
     * 获取注解上的 replacer 参数
     *
     * @param annotation 注解信息
     * @return 待替换的字符串
     */
    abstract String getReplacer(T annotation);

}
