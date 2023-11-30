package cn.cactus.module.system.job;

import cn.cactus.framework.quartz.core.handler.JobHandler;
import cn.cactus.framework.tenant.core.context.TenantContextHolder;
import cn.cactus.framework.tenant.core.job.TenantJob;
import cn.cactus.module.system.dal.dataobject.user.AdminUserDO;
import cn.cactus.module.system.dal.mysql.user.AdminUserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Package: cn.cactus.module.system.job
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 10:06
 * @Github https://github.com/lixuanfengs
 */
@Component
public class DemoJob implements JobHandler {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    @TenantJob // 标记多租户
    public String execute(String param) {
        System.out.println("当前租户：" + TenantContextHolder.getTenantId());
        List<AdminUserDO> users = adminUserMapper.selectList();
        return "用户数量：" + users.size();
    }

}