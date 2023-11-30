package cn.cactus.module.infra.enums.job;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.quartz.impl.jdbcjobstore.Constants;

import java.util.Collections;
import java.util.Set;

/**
 * Package: cn.cactus.module.infra.enums.job
 * Description:
 * 任务状态的枚举
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:40
 * @Github https://github.com/lixuanfengs
 */
@Getter
@AllArgsConstructor
public enum JobStatusEnum {

    /**
     * 初始化中
     */
    INIT(0, Collections.emptySet()),
    /**
     * 开启
     */
    NORMAL(1, Sets.newHashSet(Constants.STATE_WAITING, Constants.STATE_ACQUIRED, Constants.STATE_BLOCKED)),
    /**
     * 暂停
     */
    STOP(2, Sets.newHashSet(Constants.STATE_PAUSED, Constants.STATE_PAUSED_BLOCKED));

    /**
     * 状态
     */
    private final Integer status;
    /**
     * 对应的 Quartz 触发器的状态集合
     */
    private final Set<String> quartzStates;

}
