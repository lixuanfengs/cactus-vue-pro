package cn.cactus.framework.excel.core.annotations;

import java.lang.annotation.*;

/**
 * Package: cn.cactus.framework.excel.core.annotations
 * Description:
 * 字典格式化
 *
 * 实现将字典数据的值，格式化成字典数据的标签
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 17:59
 * @Github https://github.com/lixuanfengs
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface DictFormat {

    /**
     * 例如说，SysDictTypeConstants、InfDictTypeConstants
     *
     * @return 字典类型
     */
    String value();
}
