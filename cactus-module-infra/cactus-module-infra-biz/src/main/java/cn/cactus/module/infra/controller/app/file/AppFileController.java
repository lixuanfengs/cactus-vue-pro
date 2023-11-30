package cn.cactus.module.infra.controller.app.file;

import cn.cactus.framework.common.pojo.CommonResult;
import cn.cactus.module.infra.controller.app.file.vo.AppFileUploadReqVO;
import cn.cactus.module.infra.service.file.FileService;
import cn.hutool.core.io.IoUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

import static cn.cactus.framework.common.pojo.CommonResult.success;

/**
 * Package: cn.cactus.module.infra.controller.app.file
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:09
 * @Github https://github.com/lixuanfengs
 */
@Tag(name = "用户 App - 文件存储")
@RestController
@RequestMapping("/infra/file")
@Validated
@Slf4j
public class AppFileController {

    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    @Operation(summary = "上传文件")
    public CommonResult<String> uploadFile(AppFileUploadReqVO uploadReqVO) throws Exception {
        MultipartFile file = uploadReqVO.getFile();
        String path = uploadReqVO.getPath();
        return success(fileService.createFile(file.getOriginalFilename(), path, IoUtil.readBytes(file.getInputStream())));
    }

}
