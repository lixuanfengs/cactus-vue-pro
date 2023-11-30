package cn.cactus.framework.quartz.config;

import cn.cactus.framework.quartz.core.scheduler.SchedulerManager;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Scheduler;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Optional;

/**
 * Package: cn.cactus.framework.quartz.config
 * Description:
 * 定时任务 Configuration
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/17 16:23
 * @Github https://github.com/lixuanfengs
 */
@AutoConfiguration
@EnableScheduling // 开启 Spring 自带的定时任务
@Slf4j
public class CactusQuartzAutoConfiguration {

    @Bean
    public SchedulerManager schedulerManager(Optional<Scheduler> scheduler) {
        if (!scheduler.isPresent()) {
            log.info("[定时任务 - 已禁用][参考 https://cactusli.net/job/ 开启]");
            return new SchedulerManager(null);
        }
        return new SchedulerManager(scheduler.get());
    }

}
