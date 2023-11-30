package cn.cactus.module.system.convert.ip;

import cn.cactus.framework.ip.core.Area;
import cn.cactus.module.system.controller.admin.ip.vo.AreaNodeRespVO;
import cn.cactus.module.system.controller.app.ip.vo.AppAreaNodeRespVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:49
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface AreaConvert {

    AreaConvert INSTANCE = Mappers.getMapper(AreaConvert.class);

    List<AreaNodeRespVO> convertList(List<Area> list);

    List<AppAreaNodeRespVO> convertList3(List<Area> list);

}
