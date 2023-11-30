package cn.cactus.module.system.api.sensitiveword;

import java.util.List;

/**
 * Package: cn.cactus.module.system.api.sensitiveword
 * Description:
 * 敏感词 API 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:22
 * @Github https://github.com/lixuanfengs
 */
public interface SensitiveWordApi {

    /**
     * 获得文本所包含的不合法的敏感词数组
     *
     * @param text 文本
     * @param tags 标签数组
     * @return 不合法的敏感词数组
     */
    List<String> validateText(String text, List<String> tags);

    /**
     * 判断文本是否包含敏感词
     *
     * @param text 文本
     * @param tags 表述数组
     * @return 是否包含
     */
    boolean isTextValid(String text, List<String> tags);

}
