package cn.cactus.module.system.convert.auth;

import cn.cactus.module.system.api.sms.dto.code.SmsCodeSendReqDTO;
import cn.cactus.module.system.api.sms.dto.code.SmsCodeUseReqDTO;
import cn.cactus.module.system.api.social.dto.SocialUserBindReqDTO;
import cn.cactus.module.system.controller.admin.auth.vo.*;
import cn.cactus.module.system.dal.dataobject.oauth2.OAuth2AccessTokenDO;
import cn.cactus.module.system.dal.dataobject.permission.MenuDO;
import cn.cactus.module.system.dal.dataobject.permission.RoleDO;
import cn.cactus.module.system.dal.dataobject.user.AdminUserDO;
import cn.cactus.module.system.enums.permission.MenuTypeEnum;
import cn.hutool.core.collection.CollUtil;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.slf4j.LoggerFactory;

import java.util.*;

import static cn.cactus.framework.common.util.collection.CollectionUtils.convertSet;
import static cn.cactus.framework.common.util.collection.CollectionUtils.filterList;
import static cn.cactus.module.system.dal.dataobject.permission.MenuDO.ID_ROOT;

/**
 * Package: cn.cactus.module.system.convert.auth
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 14:36
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface AuthConvert {
    AuthConvert INSTANCE = Mappers.getMapper(AuthConvert.class);

    AuthLoginRespVO convert(OAuth2AccessTokenDO bean);

    default AuthPermissionInfoRespVO convert(AdminUserDO user, List<RoleDO> roleList, List<MenuDO> menuList) {
        return AuthPermissionInfoRespVO.builder()
                .user(AuthPermissionInfoRespVO.UserVO.builder().id(user.getId()).nickname(user.getNickname()).avatar(user.getAvatar()).build())
                .roles(convertSet(roleList, RoleDO::getCode))
                // 权限标识信息
                .permissions(convertSet(menuList, MenuDO::getPermission))
                // 菜单树
                .menus(buildMenuTree(menuList))
                .build();
    }

    AuthPermissionInfoRespVO.MenuVO convertTreeNode(MenuDO menu);

    /**
     * 将菜单列表，构建成菜单树
     *
     * @param menuList 菜单列表
     * @return 菜单树
     */
    default List<AuthPermissionInfoRespVO.MenuVO> buildMenuTree(List<MenuDO> menuList) {
        if (CollUtil.isEmpty(menuList)) {
            return Collections.emptyList();
        }
        // 移除按钮
        menuList.removeIf(menu -> menu.getType().equals(MenuTypeEnum.BUTTON.getType()));
        // 排序，保证菜单的有序性
        menuList.sort(Comparator.comparing(MenuDO::getSort));

        // 构建菜单树
        // 使用 LinkedHashMap 的原因，是为了排序 。实际也可以用 Stream API ，就是太丑了。
        Map<Long, AuthPermissionInfoRespVO.MenuVO> treeNodeMap = new LinkedHashMap<>();
        menuList.forEach(menu -> treeNodeMap.put(menu.getId(), AuthConvert.INSTANCE.convertTreeNode(menu)));
        // 处理父子关系
        treeNodeMap.values().stream().filter(node -> !node.getParentId().equals(ID_ROOT)).forEach(childNode -> {
            // 获得父节点
            AuthPermissionInfoRespVO.MenuVO parentNode = treeNodeMap.get(childNode.getParentId());
            if (parentNode == null) {
                LoggerFactory.getLogger(getClass()).error("[buildRouterTree][resource({}) 找不到父资源({})]",
                        childNode.getId(), childNode.getParentId());
                return;
            }
            // 将自己添加到父节点中
            if (parentNode.getChildren() == null) {
                parentNode.setChildren(new ArrayList<>());
            }
            parentNode.getChildren().add(childNode);
        });
        // 获得到所有的根节点
        return filterList(treeNodeMap.values(), node -> ID_ROOT.equals(node.getParentId()));
    }

    SocialUserBindReqDTO convert(Long userId, Integer userType, AuthSocialLoginReqVO reqVO);

    SmsCodeSendReqDTO convert(AuthSmsSendReqVO reqVO);

    SmsCodeUseReqDTO convert(AuthSmsLoginReqVO reqVO, Integer scene, String usedIp);
}
