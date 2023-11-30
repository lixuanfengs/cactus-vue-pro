package cn.cactus.framework.common.util.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.time.Duration;
import java.util.concurrent.Executors;

/**
 * Package: cn.cactus.framework.common.util.cache
 * Description:
 * Cache 工具类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/9 11:10
 * @Github https://github.com/lixuanfengs
 */
public class CacheUtils {

    public static <K, V> LoadingCache<K, V> buildAsyncReloadingCache(Duration duration, CacheLoader<K, V> loader) {
        return CacheBuilder.newBuilder()
                // 只阻塞当前数据加载线程，其他线程返回旧值
                .refreshAfterWrite(duration)
                // 通过 asyncReloading 实现全异步加载，包括 refreshAfterWrite 被阻塞的加载线程
                .build(CacheLoader.asyncReloading(loader, Executors.newCachedThreadPool())); // TODO 仙人球：可能要思考下，未来要不要做成可配置
    }
}
