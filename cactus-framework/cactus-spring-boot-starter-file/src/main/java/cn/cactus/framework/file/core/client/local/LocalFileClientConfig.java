package cn.cactus.framework.file.core.client.local;

import cn.cactus.framework.file.core.client.FileClientConfig;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;

/**
 * Package: cn.cactus.framework.file.core.client.local
 * Description:
 * 本地文件客户端的配置类
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:57
 * @Github https://github.com/lixuanfengs
 */
@Data
public class LocalFileClientConfig implements FileClientConfig {

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

}
