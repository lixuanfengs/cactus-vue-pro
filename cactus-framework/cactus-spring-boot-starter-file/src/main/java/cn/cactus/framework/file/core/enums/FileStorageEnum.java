package cn.cactus.framework.file.core.enums;

import cn.cactus.framework.file.core.client.FileClient;
import cn.cactus.framework.file.core.client.FileClientConfig;
import cn.cactus.framework.file.core.client.db.DBFileClient;
import cn.cactus.framework.file.core.client.db.DBFileClientConfig;
import cn.cactus.framework.file.core.client.ftp.FtpFileClient;
import cn.cactus.framework.file.core.client.ftp.FtpFileClientConfig;
import cn.cactus.framework.file.core.client.local.LocalFileClient;
import cn.cactus.framework.file.core.client.local.LocalFileClientConfig;
import cn.cactus.framework.file.core.client.s3.S3FileClient;
import cn.cactus.framework.file.core.client.s3.S3FileClientConfig;
import cn.cactus.framework.file.core.client.sftp.SftpFileClient;
import cn.cactus.framework.file.core.client.sftp.SftpFileClientConfig;
import cn.hutool.core.util.ArrayUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Package: cn.cactus.framework.file.core.enums
 * Description:
 * 文件存储器枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:49
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
@Getter
public enum FileStorageEnum {

    DB(1, DBFileClientConfig.class, DBFileClient.class),

    LOCAL(10, LocalFileClientConfig.class, LocalFileClient.class),
    FTP(11, FtpFileClientConfig.class, FtpFileClient.class),
    SFTP(12, SftpFileClientConfig.class, SftpFileClient.class),

    S3(20, S3FileClientConfig.class, S3FileClient.class),
    ;

    /**
     * 存储器
     */
    private final Integer storage;

    /**
     * 配置类
     */
    private final Class<? extends FileClientConfig> configClass;
    /**
     * 客户端类
     */
    private final Class<? extends FileClient> clientClass;

    public static FileStorageEnum getByStorage(Integer storage) {
        return ArrayUtil.firstMatch(o -> o.getStorage().equals(storage), values());
    }

}

