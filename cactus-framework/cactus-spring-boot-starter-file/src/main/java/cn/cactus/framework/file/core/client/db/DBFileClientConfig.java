package cn.cactus.framework.file.core.client.db;

import cn.cactus.framework.file.core.client.FileClientConfig;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

/**
 * Package: cn.cactus.framework.file.core.client.db
 * Description:
 * 基于 DB 存储的文件客户端的配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:54
 * @Github https://github.com/lixuanfengs
 */
@Data
public class DBFileClientConfig implements FileClientConfig {

    /**
     * 自定义域名
     */
    @NotEmpty(message = "domain 不能为空")
    @URL(message = "domain 必须是 URL 格式")
    private String domain;

}
