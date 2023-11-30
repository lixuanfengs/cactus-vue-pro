package cn.cactus.framework.file.core.client;

import cn.cactus.framework.file.core.enums.FileStorageEnum;
import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Package: cn.cactus.framework.file.core.client
 * Description:
 * 文件客户端的工厂实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:52
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
public class FileClientFactoryImpl implements FileClientFactory {

    /**
     * 文件客户端 Map
     * key：配置编号
     */
    private final ConcurrentMap<Long, AbstractFileClient<?>> clients = new ConcurrentHashMap<>();

    @Override
    public FileClient getFileClient(Long configId) {
        AbstractFileClient<?> client = clients.get(configId);
        if (client == null) {
            log.error("[getFileClient][配置编号({}) 找不到客户端]", configId);
        }
        return client;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <Config extends FileClientConfig> void createOrUpdateFileClient(Long configId, Integer storage, Config config) {
        AbstractFileClient<Config> client = (AbstractFileClient<Config>) clients.get(configId);
        if (client == null) {
            client = this.createFileClient(configId, storage, config);
            client.init();
            clients.put(client.getId(), client);
        } else {
            client.refresh(config);
        }
    }

    @SuppressWarnings("unchecked")
    private <Config extends FileClientConfig> AbstractFileClient<Config> createFileClient(
            Long configId, Integer storage, Config config) {
        FileStorageEnum storageEnum = FileStorageEnum.getByStorage(storage);
        Assert.notNull(storageEnum, String.format("文件配置(%s) 为空", storageEnum));
        // 创建客户端
        return (AbstractFileClient<Config>) ReflectUtil.newInstance(storageEnum.getClientClass(), configId, config);
    }

}