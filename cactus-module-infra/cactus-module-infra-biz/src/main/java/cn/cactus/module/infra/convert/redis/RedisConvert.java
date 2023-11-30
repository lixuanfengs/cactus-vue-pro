package cn.cactus.module.infra.convert.redis;

import cn.cactus.module.infra.controller.admin.redis.vo.RedisMonitorRespVO;
import cn.hutool.core.util.StrUtil;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Properties;

/**
 * Package: cn.cactus.module.infra.convert.redis
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:52
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface RedisConvert {

    RedisConvert INSTANCE = Mappers.getMapper(RedisConvert.class);

    default RedisMonitorRespVO build(Properties info, Long dbSize, Properties commandStats) {
        RedisMonitorRespVO respVO = RedisMonitorRespVO.builder().info(info).dbSize(dbSize)
                .commandStats(new ArrayList<>(commandStats.size())).build();
        commandStats.forEach((key, value) -> {
            respVO.getCommandStats().add(RedisMonitorRespVO.CommandStat.builder()
                    .command(StrUtil.subAfter((String) key, "cmdstat_", false))
                    .calls(Long.valueOf(StrUtil.subBetween((String) value, "calls=", ",")))
                    .usec(Long.valueOf(StrUtil.subBetween((String) value, "usec=", ",")))
                    .build());
        });
        return respVO;
    }

}
