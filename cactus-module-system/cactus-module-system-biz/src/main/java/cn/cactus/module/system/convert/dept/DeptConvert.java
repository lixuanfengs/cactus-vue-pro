package cn.cactus.module.system.convert.dept;

import cn.cactus.module.system.api.dept.dto.DeptRespDTO;
import cn.cactus.module.system.controller.admin.dept.vo.dept.DeptCreateReqVO;
import cn.cactus.module.system.controller.admin.dept.vo.dept.DeptRespVO;
import cn.cactus.module.system.controller.admin.dept.vo.dept.DeptSimpleRespVO;
import cn.cactus.module.system.controller.admin.dept.vo.dept.DeptUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.dept.DeptDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
 * Package: cn.cactus.module.system.convert.dept
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 14:38
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface DeptConvert {

    DeptConvert INSTANCE = Mappers.getMapper(DeptConvert.class);

    List<DeptRespVO> convertList(List<DeptDO> list);

    List<DeptSimpleRespVO> convertList02(List<DeptDO> list);

    DeptRespVO convert(DeptDO bean);

    DeptDO convert(DeptCreateReqVO bean);

    DeptDO convert(DeptUpdateReqVO bean);

    List<DeptRespDTO> convertList03(List<DeptDO> list);

    DeptRespDTO convert03(DeptDO bean);

}
