package cn.cactus.framework.common.util.monitor;

import org.apache.skywalking.apm.toolkit.trace.TraceContext;

/**
 * Package: cn.cactus.framework.common.util.monitor
 * Description:
 *
 * 链路追踪工具类
 *
 * 考虑到每个 starter 都需要用到该工具类，所以放到 common 模块下的 util 包下
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/10 10:17
 * @Github https://github.com/lixuanfengs
 */
public class TracerUtils {

    /**
     * 私有化构造方法
     */
    private TracerUtils() {
    }

    /**
     * 获得链路追踪编号，直接返回 SkyWalking 的 TraceId。
     * 如果不存在的话为空字符串！！！
     *
     * @return 链路追踪编号
     */
    public static String getTraceId() {
        return TraceContext.traceId();
    }

}
