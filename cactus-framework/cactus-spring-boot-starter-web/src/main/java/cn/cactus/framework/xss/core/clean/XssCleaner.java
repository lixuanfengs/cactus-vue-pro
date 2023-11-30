package cn.cactus.framework.xss.core.clean;

/**
 * Package: cn.cactus.framework.xss.core.clean
 * Description:
 * 对 html 文本中的有 Xss 风险的数据进行清理
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:15
 * @Github https://github.com/lixuanfengs
 */
public interface XssCleaner {

    /**
     * 清理有 Xss 风险的文本
     *
     * @param html 原 html
     * @return 清理后的 html
     */
    String clean(String html);
}
