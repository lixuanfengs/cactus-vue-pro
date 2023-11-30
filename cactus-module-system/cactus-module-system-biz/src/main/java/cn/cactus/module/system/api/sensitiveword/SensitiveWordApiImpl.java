package cn.cactus.module.system.api.sensitiveword;

import cn.cactus.module.system.service.sensitiveword.SensitiveWordService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Package: cn.cactus.module.system.api.sensitiveword
 * Description:
 * 敏感词 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 16:56
 * @Github https://github.com/lixuanfengs
 */
@Service
public class SensitiveWordApiImpl implements SensitiveWordApi {

    @Resource
    private SensitiveWordService sensitiveWordService;

    @Override
    public List<String> validateText(String text, List<String> tags) {
        return sensitiveWordService.validateText(text, tags);
    }

    @Override
    public boolean isTextValid(String text, List<String> tags) {
        return sensitiveWordService.isTextValid(text, tags);
    }
}