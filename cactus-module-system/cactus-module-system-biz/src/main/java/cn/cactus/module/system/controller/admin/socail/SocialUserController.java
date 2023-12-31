package cn.cactus.module.system.controller.admin.socail;

import cn.cactus.framework.common.enums.UserTypeEnum;
import cn.cactus.framework.common.pojo.CommonResult;
import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.socail.vo.SocialUserBindReqVO;
import cn.cactus.module.system.controller.admin.socail.vo.SocialUserUnbindReqVO;
import cn.cactus.module.system.controller.admin.socail.vo.user.SocialUserPageReqVO;
import cn.cactus.module.system.controller.admin.socail.vo.user.SocialUserRespVO;
import cn.cactus.module.system.convert.social.SocialUserConvert;
import cn.cactus.module.system.dal.dataobject.social.SocialUserDO;
import cn.cactus.module.system.service.social.SocialUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

import static cn.cactus.framework.common.pojo.CommonResult.success;
import static cn.cactus.framework.security.core.util.SecurityFrameworkUtils.getLoginUserId;

/**
 * Package: cn.cactus.module.system.controller.admin.sms.socail
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 11:24
 * @Github https://github.com/lixuanfengs
 */
@Tag(name = "管理后台 - 社交用户")
@RestController
@RequestMapping("/system/social-user")
@Validated
public class SocialUserController {

    @Resource
    private SocialUserService socialUserService;

    @PostMapping("/bind")
    @Operation(summary = "社交绑定，使用 code 授权码")
    public CommonResult<Boolean> socialBind(@RequestBody @Valid SocialUserBindReqVO reqVO) {
        socialUserService.bindSocialUser(SocialUserConvert.INSTANCE.convert(getLoginUserId(), UserTypeEnum.ADMIN.getValue(), reqVO));
        return success(true);
    }

    @DeleteMapping("/unbind")
    @Operation(summary = "取消社交绑定")
    public CommonResult<Boolean> socialUnbind(@RequestBody SocialUserUnbindReqVO reqVO) {
        socialUserService.unbindSocialUser(getLoginUserId(), UserTypeEnum.ADMIN.getValue(), reqVO.getType(), reqVO.getOpenid());
        return success(true);
    }

    // ==================== 社交用户 CRUD ====================

    @GetMapping("/get")
    @Operation(summary = "获得社交用户")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('system:social-user:query')")
    public CommonResult<SocialUserRespVO> getSocialUser(@RequestParam("id") Long id) {
        SocialUserDO socialUser = socialUserService.getSocialUser(id);
        return success(SocialUserConvert.INSTANCE.convert(socialUser));
    }

    @GetMapping("/page")
    @Operation(summary = "获得社交用户分页")
    @PreAuthorize("@ss.hasPermission('system:social-user:query')")
    public CommonResult<PageResult<SocialUserRespVO>> getSocialUserPage(@Valid SocialUserPageReqVO pageVO) {
        PageResult<SocialUserDO> pageResult = socialUserService.getSocialUserPage(pageVO);
        return success(SocialUserConvert.INSTANCE.convertPage(pageResult));
    }

}
