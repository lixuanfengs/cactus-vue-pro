package cn.cactus.framework.file.core.client.sftp;

import cn.cactus.framework.file.core.client.FileClientConfig;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.framework.file.core.client.sftp
 * Description:
 * Sftp 文件客户端的配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:59
 * @Github https://github.com/lixuanfengs
 */
@Data
public class SftpFileClientConfig implements FileClientConfig {

    /**
     * 基础路径
     */
    @NotEmpty(message = "基础路径不能为空")
    private String basePath;

    /**
     * 自定义域名
     */
    @NotEmpty(message = "domain 不能为空")
    @URL(message = "domain 必须是 URL 格式")
    private String domain;

    /**
     * 主机地址
     */
    @NotEmpty(message = "host 不能为空")
    private String host;
    /**
     * 主机端口
     */
    @NotNull(message = "port 不能为空")
    private Integer port;
    /**
     * 用户名
     */
    @NotEmpty(message = "用户名不能为空")
    private String username;
    /**
     * 密码
     */
    @NotEmpty(message = "密码不能为空")
    private String password;

}

