package cn.cactus.framework.tracer.core.util;

import io.opentracing.Span;
import io.opentracing.tag.Tags;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Package: cn.cactus.framework.tracer.core.util
 * Description:
 * 链路追踪 Util
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:10
 * @Github https://github.com/lixuanfengs
 */
public class TracerFrameworkUtils {

    /**
     * 将异常记录到 Span 中，参考自 com.aliyuncs.utils.TraceUtils
     *
     * @param throwable 异常
     * @param span Span
     */
    public static void onError(Throwable throwable, Span span) {
        Tags.ERROR.set(span, Boolean.TRUE);
        if (throwable != null) {
            span.log(errorLogs(throwable));
        }
    }

    private static Map<String, Object> errorLogs(Throwable throwable) {
        Map<String, Object> errorLogs = new HashMap<String, Object>(10);
        errorLogs.put("event", Tags.ERROR.getKey());
        errorLogs.put("error.object", throwable);
        errorLogs.put("error.kind", throwable.getClass().getName());
        String message = throwable.getCause() != null ? throwable.getCause().getMessage() : throwable.getMessage();
        if (message != null) {
            errorLogs.put("message", message);
        }
        StringWriter sw = new StringWriter();
        throwable.printStackTrace(new PrintWriter(sw));
        errorLogs.put("stack", sw.toString());
        return errorLogs;
    }

}
