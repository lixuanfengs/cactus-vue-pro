package cn.cactus.module.system.dal.dataobject.dept;

import cn.cactus.framework.common.enums.CommonStatusEnum;
import cn.cactus.framework.tenant.core.db.TenantBaseDO;
import cn.cactus.module.system.dal.dataobject.user.AdminUserDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Package: cn.cactus.module.system.dal.dataobject.dept
 * Description:
 * 部门表
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/20 11:20
 * @Github https://github.com/lixuanfengs
 */
@TableName("system_dept")
@KeySequence("system_dept_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
public class DeptDO extends TenantBaseDO {

    /**
     * 部门ID
     */
    @TableId
    private Long id;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 父部门ID
     *
     * 关联 {@link #id}
     */
    private Long parentId;
    /**
     * 显示顺序
     */
    private Integer sort;
    /**
     * 负责人
     *
     * 关联 {@link AdminUserDO#getId()}
     */
    private Long leaderUserId;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 部门状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;

}