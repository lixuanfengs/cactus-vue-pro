package cn.cactus.module.infra.controller.app.file.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;

/**
 * Package: cn.cactus.module.infra.controller.app.file.vo
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/27 17:09
 * @Github https://github.com/lixuanfengs
 */
@Schema(description = "用户 App - 上传文件 Request VO")
@Data
public class AppFileUploadReqVO {

    @Schema(description = "文件附件", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotNull(message = "文件附件不能为空")
    private MultipartFile file;

    @Schema(description = "文件附件", example = "yudaoyuanma.png")
    private String path;

}