package cn.cactus.framework.web.core.filter;

import cn.cactus.framework.web.config.WebProperties;
import cn.hutool.core.util.StrUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Package: cn.cactus.framework.web.core.filter
 * Description:
 * 过滤 /admin-api、/app-api 等 API 请求的过滤器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/16 9:44
 * @Github https://github.com/lixuanfengs
 */
@RequiredArgsConstructor
public abstract class ApiRequestFilter extends OncePerRequestFilter  {

    protected final WebProperties webProperties;

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // 只过滤 API 请求的地址
        return !StrUtil.startWithAny(request.getRequestURI(), webProperties.getAdminApi().getPrefix(),
                webProperties.getAppApi().getPrefix());
    }


}
