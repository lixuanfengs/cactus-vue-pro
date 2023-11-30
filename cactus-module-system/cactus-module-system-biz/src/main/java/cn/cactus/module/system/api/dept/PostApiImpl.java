package cn.cactus.module.system.api.dept;

import cn.cactus.module.system.service.dept.PostService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;

/**
 * Package: cn.cactus.module.system.api.dept
 * Description:
 * 岗位 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:52
 * @Github https://github.com/lixuanfengs
 */
@Service
public class PostApiImpl implements PostApi {

    @Resource
    private PostService postService;

    @Override
    public void validPostList(Collection<Long> ids) {
        postService.validatePostList(ids);
    }

}

