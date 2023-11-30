package cn.cactus.module.system.dal.dataobject.sms;

import cn.cactus.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

import java.time.LocalDateTime;

/**
 * Package: cn.cactus.module.system.dal.dataobject.sms
 * Description:
 * 手机验证码 DO
 *
 * idx_mobile 索引：基于 {@link #mobile} 字段
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 17:11
 * @Github https://github.com/lixuanfengs
 */
@TableName("system_sms_code")
@KeySequence("system_sms_code_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SmsCodeDO extends BaseDO {

    /**
     * 编号
     */
    private Long id;
    /**
     * 手机号
     */
    private String mobile;
    /**
     * 验证码
     */
    private String code;
    /**
     * 发送场景
     *
     * 枚举 {@link SmsCodeDO}
     */
    private Integer scene;
    /**
     * 创建 IP
     */
    private String createIp;
    /**
     * 今日发送的第几条
     */
    private Integer todayIndex;
    /**
     * 是否使用
     */
    private Boolean used;
    /**
     * 使用时间
     */
    private LocalDateTime usedTime;
    /**
     * 使用 IP
     */
    private String usedIp;

}
