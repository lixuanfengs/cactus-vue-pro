package cn.cactus.framework.web.core.filter;

import cn.cactus.framework.common.util.servlet.ServletUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Package: cn.cactus.framework.web.core.filter
 * Description:
 * Request Body 缓存 Filter，实现它的可重复读取
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/16 9:48
 * @Github https://github.com/lixuanfengs
 */
public class CacheRequestBodyFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        filterChain.doFilter(new CacheRequestBodyWrapper(request), response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // 只处理 json 请求内容
        return !ServletUtils.isJsonRequest(request);
    }

}
