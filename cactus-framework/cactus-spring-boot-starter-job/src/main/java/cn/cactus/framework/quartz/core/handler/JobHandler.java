package cn.cactus.framework.quartz.core.handler;

/**
 * Package: cn.cactus.framework.quartz.core.handler
 * Description:
 * 任务处理器
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 16:16
 * @Github https://github.com/lixuanfengs
 */
public interface JobHandler {

    /**
     * 执行任务
     *
     * @param param 参数
     * @return 结果
     * @throws Exception 异常
     */
    String execute(String param) throws Exception;

}
