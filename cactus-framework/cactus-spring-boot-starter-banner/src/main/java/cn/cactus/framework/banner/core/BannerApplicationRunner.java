package cn.cactus.framework.banner.core;

import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.util.ClassUtils;

import java.util.concurrent.TimeUnit;

/**
 * Package: cn.cactus.framework.banner.core
 * Description:
 * 项目启动成功后，提供文档相关的地址
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/10 17:50
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
public class BannerApplicationRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ThreadUtil.execute(() -> {
            ThreadUtil.sleep(1, TimeUnit.SECONDS);
            log.info("\n----------------------------------------------------------\n\t" +
                            "项目启动成功！\n\t" +
                            "接口文档: \t{} \n\t" +
                            "开发文档: \t{} \n\t" +
                            "----------------------------------------------------------",
                    "https://cactusli.net/api-doc/",
                    "https://cactusli.net");
        });
        // 数据报表
        if (isNotPresent("cn.cactus.module.report.framework.security.config.SecurityConfiguration")) {
            System.out.println("[报表模块 cactus-module-report - 已禁用][参考 https://cactusli.net/report/ 开启]");
        }
        // 工作流
        if (isNotPresent("cn.cactus.framework.flowable.config.YudaoFlowableConfiguration")) {
            System.out.println("[工作流模块 cactus-module-bpm - 已禁用][参考 https://cactusli.net/bpm/ 开启]");
        }
    }

    private static boolean isNotPresent(String className) {
        return !ClassUtils.isPresent(className, ClassUtils.getDefaultClassLoader());
    }
}
