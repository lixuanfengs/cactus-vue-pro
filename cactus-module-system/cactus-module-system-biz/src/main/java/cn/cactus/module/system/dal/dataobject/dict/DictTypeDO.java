package cn.cactus.module.system.dal.dataobject.dict;

import cn.cactus.framework.common.enums.CommonStatusEnum;
import cn.cactus.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.system.dal.dataobject.dict
 * Description:
 * 字典类型表
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/15 10:13
 * @Github https://github.com/lixuanfengs
 */
@TableName("system_dict_type")
@KeySequence("system_dict_type_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DictTypeDO extends BaseDO {

    /**
     * 字典主键
     */
    @TableId
    private Long id;
    /**
     * 字典名称
     */
    private String name;
    /**
     * 字典类型
     */
    private String type;
    /**
     * 状态
     *
     * 枚举 {@link CommonStatusEnum}
     */
    private Integer status;
    /**
     * 备注
     */
    private String remark;

    /**
     * 删除时间
     */
    private LocalDateTime deletedTime;

}
