package cn.cactus.framework.datasource.core.enums;

/**
 * Package: cn.cactus.framework.datasource.core
 * Description:
 * 对应于多数据源中不同数据源配置
 *
 * 通过在方法上，使用 {@link com.baomidou.dynamic.datasource.annotation.DS} 注解，设置使用的数据源。
 * 注意，默认是 {@link #MASTER} 数据源
 *
 * 对应官方文档为 http://dynamic-datasource.com/guide/customize/Annotation.html
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 15:26
 * @Github https://github.com/lixuanfengs
 */
public interface DataSourceEnum {

    /**
     * 主库，推荐使用 {@link com.baomidou.dynamic.datasource.annotation.Master} 注解
     */
    String MASTER = "master";
    /**
     * 从库，推荐使用 {@link com.baomidou.dynamic.datasource.annotation.Slave} 注解
     */
    String SLAVE = "slave";

}
