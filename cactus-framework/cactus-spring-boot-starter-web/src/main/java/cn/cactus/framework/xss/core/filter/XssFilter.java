package cn.cactus.framework.xss.core.filter;

import cn.cactus.framework.xss.config.XssProperties;
import cn.cactus.framework.xss.core.clean.XssCleaner;
import lombok.AllArgsConstructor;
import org.springframework.util.PathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Package: cn.cactus.framework.xss.core.filter
 * Description:
 * Xss 过滤器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 10:16
 * @Github https://github.com/lixuanfengs
 */
@AllArgsConstructor
public class XssFilter extends OncePerRequestFilter {

    /**
     * 属性
     */
    private final XssProperties properties;
    /**
     * 路径匹配器
     */
    private final PathMatcher pathMatcher;

    private final XssCleaner xssCleaner;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        filterChain.doFilter(new XssRequestWrapper(request, xssCleaner), response);
    }

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        // 如果关闭，则不过滤
        if (!properties.isEnable()) {
            return true;
        }

        // 如果匹配到无需过滤，则不过滤
        String uri = request.getRequestURI();
        return properties.getExcludeUrls().stream().anyMatch(excludeUrl -> pathMatcher.match(excludeUrl, uri));
    }

}
