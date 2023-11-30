package cn.cactus.module.infra.api.file;

import cn.cactus.module.infra.service.file.FileService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.annotation.Resource;

/**
 * Package: cn.cactus.module.infra.api.file
 * Description:
 * 文件 API 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 15:16
 * @Github https://github.com/lixuanfengs
 */
@Service
@Validated
public class FileApiImpl implements FileApi {

    @Resource
    private FileService fileService;

    @Override
    public String createFile(String name, String path, byte[] content) {
        return fileService.createFile(name, path, content);
    }

}
