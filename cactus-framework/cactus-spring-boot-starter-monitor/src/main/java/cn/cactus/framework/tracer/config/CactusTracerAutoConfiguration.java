package cn.cactus.framework.tracer.config;

import cn.cactus.framework.common.enums.WebFilterOrderEnum;
import cn.cactus.framework.tracer.core.aop.BizTraceAspect;
import cn.cactus.framework.tracer.core.filter.TraceFilter;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Package: cn.cactus.framework.tracer.config
 * Description:
 * Tracer 配置类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:13
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration
@ConditionalOnClass({BizTraceAspect.class})
@EnableConfigurationProperties(TracerProperties.class)
@ConditionalOnProperty(prefix = "cactus.tracer", value = "enable", matchIfMissing = true)
public class CactusTracerAutoConfiguration {
    // TODO cactus：重要。目前 opentracing 版本存在冲突，要么保证 skywalking，要么保证阿里云短信 sdk
//    @Bean
//    public TracerProperties bizTracerProperties() {
//        return new TracerProperties();
//    }
//
//    @Bean
//    public BizTraceAspect bizTracingAop() {
//        return new BizTraceAspect(tracer());
//    }
//
//    @Bean
//    public Tracer tracer() {
//        // 创建 SkywalkingTracer 对象
//        SkywalkingTracer tracer = new SkywalkingTracer();
//        // 设置为 GlobalTracer 的追踪器
//        GlobalTracer.register(tracer);
//        return tracer;
//    }

    /**
     * 创建 TraceFilter 过滤器，响应 header 设置 traceId
     */
    @Bean
    public FilterRegistrationBean<TraceFilter> traceFilter() {
        FilterRegistrationBean<TraceFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new TraceFilter());
        registrationBean.setOrder(WebFilterOrderEnum.TRACE_FILTER);
        return registrationBean;
    }

}