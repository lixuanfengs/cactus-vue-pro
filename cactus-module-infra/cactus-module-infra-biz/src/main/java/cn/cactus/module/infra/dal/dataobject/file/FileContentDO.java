package cn.cactus.module.infra.dal.dataobject.file;

import cn.cactus.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * Package: cn.cactus.module.infra.dal.dataobject.file
 * Description:
 * 专门用于存储 {@link cn.cactus.framework.file.core.client.db.DBFileClient} 的文件内容
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:37
 * @Github https://github.com/lixuanfengs
 */
@TableName("infra_file_content")
@KeySequence("infra_file_content_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileContentDO extends BaseDO {

    /**
     * 编号，数据库自增
     */
    @TableId(type = IdType.INPUT)
    private String id;
    /**
     * 配置编号
     *
     * 关联 {@link FileConfigDO#getId()}
     */
    private Long configId;
    /**
     * 路径，即文件名
     */
    private String path;
    /**
     * 文件内容
     */
    private byte[] content;

}

