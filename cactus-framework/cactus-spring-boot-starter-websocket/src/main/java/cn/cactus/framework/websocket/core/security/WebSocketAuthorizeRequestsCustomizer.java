package cn.cactus.framework.websocket.core.security;

import cn.cactus.framework.security.config.AuthorizeRequestsCustomizer;
import cn.cactus.framework.websocket.config.WebSocketProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

/**
 * Package: cn.cactus.framework.websocket.core.security
 * Description:
 * WebSocket 的权限自定义
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/29 16:05
 * @Github https://github.com/lixuanfengs
 */
@RequiredArgsConstructor
public class WebSocketAuthorizeRequestsCustomizer extends AuthorizeRequestsCustomizer {

    private final WebSocketProperties webSocketProperties;

    @Override
    public void customize(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry) {
        registry.antMatchers(webSocketProperties.getPath()).permitAll();
    }

}