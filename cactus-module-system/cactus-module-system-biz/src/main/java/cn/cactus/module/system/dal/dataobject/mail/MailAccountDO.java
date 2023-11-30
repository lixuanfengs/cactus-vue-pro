package cn.cactus.module.system.dal.dataobject.mail;

import cn.cactus.framework.mybatis.core.dataobject.BaseDO;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Package: cn.cactus.module.system.dal.dataobject.mail
 * Description:
 * 邮箱账号 DO
 *
 * 用途：配置发送邮箱的账号
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 15:54
 * @Github https://github.com/lixuanfengs
 */
@TableName(value = "system_mail_account", autoResultMap = true)
@Data
@EqualsAndHashCode(callSuper = true)
public class MailAccountDO extends BaseDO {

    /**
     * 主键
     */
    @TableId
    private Long id;
    /**
     * 邮箱
     */
    private String mail;

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * SMTP 服务器域名
     */
    private String host;
    /**
     * SMTP 服务器端口
     */
    private Integer port;
    /**
     * 是否开启 SSL
     */
    private Boolean sslEnable;

}
