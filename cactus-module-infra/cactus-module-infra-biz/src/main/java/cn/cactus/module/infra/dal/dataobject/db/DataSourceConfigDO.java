package cn.cactus.module.infra.dal.dataobject.db;

import cn.cactus.framework.mybatis.core.dataobject.BaseDO;
import cn.cactus.framework.mybatis.core.type.EncryptTypeHandler;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * Package: cn.cactus.module.infra.dal.dataobject.db
 * Description:
 * 数据源配置
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:36
 * @Github https://github.com/lixuanfengs
 */
@TableName(value = "infra_data_source_config", autoResultMap = true)
@KeySequence("infra_data_source_config_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
public class DataSourceConfigDO extends BaseDO {

    /**
     * 主键编号 - Master 数据源
     */
    public static final Long ID_MASTER = 0L;

    /**
     * 主键编号
     */
    private Long id;
    /**
     * 连接名
     */
    private String name;

    /**
     * 数据源连接
     */
    private String url;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    @TableField(typeHandler = EncryptTypeHandler.class)
    private String password;

}