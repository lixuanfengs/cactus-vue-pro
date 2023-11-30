package cn.cactus.module.system.dal.dataobject.notice;

import cn.cactus.framework.common.enums.CommonStatusEnum;
import cn.cactus.framework.mybatis.core.dataobject.BaseDO;
import cn.cactus.module.system.enums.notice.NoticeTypeEnum;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Package: cn.cactus.module.system.dal.dataobject.notice
 * Description:
 * 通知公告表
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 16:03
 * @Github https://github.com/lixuanfengs
 */
@TableName("system_notice")
@KeySequence("system_notice_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
public class NoticeDO extends BaseDO {

    /**
     * 公告ID
     */
    private Long id;
    /**
     * 公告标题
     */
    private String title;
    /**
     * 公告类型
     *
     * 枚举 {@link NoticeTypeEnum}
     */
    private Integer type;
    /**
     * 公告内容
     */
    private String content;
    /**
     * 公告状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

}
