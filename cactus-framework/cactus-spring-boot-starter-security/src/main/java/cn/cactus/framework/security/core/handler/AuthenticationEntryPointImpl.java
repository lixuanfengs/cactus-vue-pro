package cn.cactus.framework.security.core.handler;

import cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants;
import cn.cactus.framework.common.pojo.CommonResult;
import cn.cactus.framework.common.util.servlet.ServletUtils;
import cn.cactus.framework.security.core.util.SecurityFrameworkUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.ExceptionTranslationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants.FORBIDDEN;
import static cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants.UNAUTHORIZED;

/**
 * Package: cn.cactus.framework.security.core.handler
 * Description:
 * 访问一个需要认证的 URL 资源，但是此时自己尚未认证（登录）的情况下，返回 {@link GlobalErrorCodeConstants#UNAUTHORIZED} 错误码，从而使前端重定向到登录页
 *
 * 补充：Spring Security 通过 {@link ExceptionTranslationFilter#sendStartAuthentication(HttpServletRequest, HttpServletResponse, FilterChain, AuthenticationException)} 方法，调用当前类
 *
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 11:03
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
@SuppressWarnings("JavadocReference")
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        log.debug("[commence][访问 URL({}) 时，没有登录]", request.getRequestURI(), e);
        // 返回 401
        ServletUtils.writeJSON(response, CommonResult.error(UNAUTHORIZED));
    }
}
