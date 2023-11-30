package cn.cactus.module.system.convert.permission;

import cn.cactus.module.system.controller.admin.permission.vo.menu.MenuCreateReqVO;
import cn.cactus.module.system.controller.admin.permission.vo.menu.MenuRespVO;
import cn.cactus.module.system.controller.admin.permission.vo.menu.MenuSimpleRespVO;
import cn.cactus.module.system.controller.admin.permission.vo.menu.MenuUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.permission.MenuDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.permission
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:01
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface MenuConvert {

    MenuConvert INSTANCE = Mappers.getMapper(MenuConvert.class);

    List<MenuRespVO> convertList(List<MenuDO> list);

    MenuDO convert(MenuCreateReqVO bean);

    MenuDO convert(MenuUpdateReqVO bean);

    MenuRespVO convert(MenuDO bean);

    List<MenuSimpleRespVO> convertList02(List<MenuDO> list);

}
