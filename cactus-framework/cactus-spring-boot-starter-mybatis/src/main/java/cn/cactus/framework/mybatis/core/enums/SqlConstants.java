package cn.cactus.framework.mybatis.core.enums;

import com.baomidou.mybatisplus.annotation.DbType;

/**
 * Package: cn.cactus.framework.mybatis.core.enums
 * Description:
 * SQL相关常量类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 15:46
 * @Github https://github.com/lixuanfengs
 */
public class SqlConstants {

    /**
     * 数据库的类型
     */
    public static DbType DB_TYPE;

    public static void init(DbType dbType) {
        DB_TYPE = dbType;
    }

}
