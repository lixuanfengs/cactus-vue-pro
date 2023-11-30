package cn.cactus.framework.web.core.filter;

import cn.cactus.framework.common.pojo.CommonResult;
import cn.cactus.framework.common.util.servlet.ServletUtils;
import cn.cactus.framework.web.core.util.WebFrameworkUtils;
import cn.hutool.core.util.StrUtil;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static cn.cactus.framework.common.exception.enums.GlobalErrorCodeConstants.DEMO_DENY;

/**
 * Package: cn.cactus.framework.web.core.filter
 * Description:
 * 演示 Filter，禁止用户发起写操作，避免影响测试数据
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/16 9:50
 * @Github https://github.com/lixuanfengs
 */
public class DemoFilter extends OncePerRequestFilter {

    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String method = request.getMethod();
        return !StrUtil.equalsAnyIgnoreCase(method, "POST", "PUT", "DELETE")  // 写操作时，不进行过滤率
                || WebFrameworkUtils.getLoginUserId(request) == null; // 非登录用户时，不进行过滤
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) {
        // 直接返回 DEMO_DENY 的结果。即，请求不继续
        ServletUtils.writeJSON(response, CommonResult.error(DEMO_DENY));
    }
}
