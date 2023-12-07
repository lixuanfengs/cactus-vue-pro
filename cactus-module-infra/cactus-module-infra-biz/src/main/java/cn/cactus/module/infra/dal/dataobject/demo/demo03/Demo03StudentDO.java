package cn.cactus.module.infra.dal.dataobject.demo.demo03;

import cn.cactus.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.sun.xml.bind.v2.TODO;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.infra.dal.dataobject.demo.demo03
 * Description:
 * 学生 DO
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/12/7 17:06
 * @Github https://github.com/lixuanfengs
 */
@TableName("infra_demo03_student")
@KeySequence("infra_demo03_student_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Demo03StudentDO extends BaseDO {

    /**
     * 编号
     */
    @TableId
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 性别
     *
     * 枚举 {@link TODO system_user_sex 对应的类}
     */
    private Integer sex;
    /**
     * 出生日期
     */
    private LocalDateTime birthday;
    /**
     * 简介
     */
    private String description;

}
