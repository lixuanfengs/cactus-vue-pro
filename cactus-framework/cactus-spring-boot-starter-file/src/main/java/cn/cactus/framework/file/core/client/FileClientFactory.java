package cn.cactus.framework.file.core.client;

/**
 * Package: cn.cactus.framework.file.core.client
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:51
 * @Github https://github.com/lixuanfengs
 */
public interface FileClientFactory {

    /**
     * 获得文件客户端
     *
     * @param configId 配置编号
     * @return 文件客户端
     */
    FileClient getFileClient(Long configId);

    /**
     * 创建文件客户端
     *
     * @param configId 配置编号
     * @param storage 存储器的枚举 {@link cn.cactus.framework.file.core.enums.FileStorageEnum}
     * @param config 文件配置
     */
    <Config extends FileClientConfig> void createOrUpdateFileClient(Long configId, Integer storage, Config config);

}