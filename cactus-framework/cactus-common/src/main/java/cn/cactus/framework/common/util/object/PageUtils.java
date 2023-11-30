package cn.cactus.framework.common.util.object;

import cn.cactus.framework.common.pojo.PageParam;

/**
 * Package: cn.cactus.framework.common.util.object
 * Description:
 *
 * {@link cn.cactus.framework.common.pojo.PageParam} 工具类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/10 10:19
 * @Github https://github.com/lixuanfengs
 */
public class PageUtils {

    public static int getStart(PageParam pageParam) {
        return (pageParam.getPageNo() - 1) * pageParam.getPageSize();
    }

}
