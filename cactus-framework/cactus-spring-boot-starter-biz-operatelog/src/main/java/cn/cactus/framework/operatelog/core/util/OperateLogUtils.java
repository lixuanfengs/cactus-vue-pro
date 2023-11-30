package cn.cactus.framework.operatelog.core.util;

import cn.cactus.framework.operatelog.core.aop.OperateLogAspect;

/**
 * Package: cn.cactus.framework.operatelog.core.util
 * Description:
 * 操作日志工具类
 * 目前主要的作用，是提供给业务代码，记录操作明细和拓展字段
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 14:53
 * @Github https://github.com/lixuanfengs
 */
public class OperateLogUtils {

    public static void setContent(String content) {
        OperateLogAspect.setContent(content);
    }

    public static void addExt(String key, Object value) {
        OperateLogAspect.addExt(key, value);
    }

}
