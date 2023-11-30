package cn.cactus.framework.errorcode.core.generator;

/**
 * Package: cn.cactus.framework.errorcode.core.generator
 * Description:
 * 错误码的自动生成器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:16
 * @Github https://github.com/lixuanfengs
 */
public interface ErrorCodeAutoGenerator {

    /**
     * 将配置类到错误码写入数据库
     */
    void execute();

}
