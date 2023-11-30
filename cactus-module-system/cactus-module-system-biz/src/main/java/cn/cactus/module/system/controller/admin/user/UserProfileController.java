package cn.cactus.module.system.controller.admin.user;

import cn.cactus.framework.common.enums.UserTypeEnum;
import cn.cactus.framework.common.pojo.CommonResult;
import cn.cactus.framework.datapermission.core.annotation.DataPermission;
import cn.cactus.module.system.controller.admin.user.vo.profile.UserProfileRespVO;
import cn.cactus.module.system.controller.admin.user.vo.profile.UserProfileUpdatePasswordReqVO;
import cn.cactus.module.system.controller.admin.user.vo.profile.UserProfileUpdateReqVO;
import cn.cactus.module.system.convert.user.UserConvert;
import cn.cactus.module.system.dal.dataobject.dept.DeptDO;
import cn.cactus.module.system.dal.dataobject.dept.PostDO;
import cn.cactus.module.system.dal.dataobject.permission.RoleDO;
import cn.cactus.module.system.dal.dataobject.social.SocialUserDO;
import cn.cactus.module.system.dal.dataobject.user.AdminUserDO;
import cn.cactus.module.system.service.dept.DeptService;
import cn.cactus.module.system.service.dept.PostService;
import cn.cactus.module.system.service.permission.PermissionService;
import cn.cactus.module.system.service.permission.RoleService;
import cn.cactus.module.system.service.social.SocialUserService;
import cn.cactus.module.system.service.user.AdminUserService;
import cn.hutool.core.collection.CollUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.List;

import static cn.cactus.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.cactus.framework.common.pojo.CommonResult.success;
import static cn.cactus.framework.web.core.util.WebFrameworkUtils.getLoginUserId;
import static cn.cactus.module.infra.enums.ErrorCodeConstants.FILE_IS_EMPTY;

/**
 * Package: cn.cactus.module.system.controller.admin.user
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/21 10:50
 * @Github https://github.com/lixuanfengs
 */
@Tag(name = "管理后台 - 用户个人中心")
@RestController
@RequestMapping("/system/user/profile")
@Validated
@Slf4j
public class UserProfileController {

    @Resource
    private AdminUserService userService;
    @Resource
    private DeptService deptService;
    @Resource
    private PostService postService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private RoleService roleService;
    @Resource
    private SocialUserService socialService;

    @GetMapping("/get")
    @Operation(summary = "获得登录用户信息")
    @DataPermission(enable = false) // 关闭数据权限，避免只查看自己时，查询不到部门。
    public CommonResult<UserProfileRespVO> profile() {
        // 获得用户基本信息
        AdminUserDO user = userService.getUser(getLoginUserId());
        UserProfileRespVO resp = UserConvert.INSTANCE.convert03(user);
        // 获得用户角色
        List<RoleDO> userRoles = roleService.getRoleListFromCache(permissionService.getUserRoleIdListByUserId(user.getId()));
        resp.setRoles(UserConvert.INSTANCE.convertList(userRoles));
        // 获得部门信息
        if (user.getDeptId() != null) {
            DeptDO dept = deptService.getDept(user.getDeptId());
            resp.setDept(UserConvert.INSTANCE.convert02(dept));
        }
        // 获得岗位信息
        if (CollUtil.isNotEmpty(user.getPostIds())) {
            List<PostDO> posts = postService.getPostList(user.getPostIds());
            resp.setPosts(UserConvert.INSTANCE.convertList02(posts));
        }
        // 获得社交用户信息
        List<SocialUserDO> socialUsers = socialService.getSocialUserList(user.getId(), UserTypeEnum.ADMIN.getValue());
        resp.setSocialUsers(UserConvert.INSTANCE.convertList03(socialUsers));
        return success(resp);
    }

    @PutMapping("/update")
    @Operation(summary = "修改用户个人信息")
    public CommonResult<Boolean> updateUserProfile(@Valid @RequestBody UserProfileUpdateReqVO reqVO) {
        userService.updateUserProfile(getLoginUserId(), reqVO);
        return success(true);
    }

    @PutMapping("/update-password")
    @Operation(summary = "修改用户个人密码")
    public CommonResult<Boolean> updateUserProfilePassword(@Valid @RequestBody UserProfileUpdatePasswordReqVO reqVO) {
        userService.updateUserPassword(getLoginUserId(), reqVO);
        return success(true);
    }

    @RequestMapping(value = "/update-avatar", method = {RequestMethod.POST, RequestMethod.PUT}) // 解决 uni-app 不支持 Put 上传文件的问题
    @Operation(summary = "上传用户个人头像")
    public CommonResult<String> updateUserAvatar(@RequestParam("avatarFile") MultipartFile file) throws Exception {
        if (file.isEmpty()) {
            throw exception(FILE_IS_EMPTY);
        }
        String avatar = userService.updateUserAvatar(getLoginUserId(), file.getInputStream());
        return success(avatar);
    }

}