package cn.cactus.module.system.convert.notice;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.notice.vo.NoticeCreateReqVO;
import cn.cactus.module.system.controller.admin.notice.vo.NoticeRespVO;
import cn.cactus.module.system.controller.admin.notice.vo.NoticeUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.notice.NoticeDO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * Package: cn.cactus.module.system.convert.notice
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 15:58
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface NoticeConvert {

    NoticeConvert INSTANCE = Mappers.getMapper(NoticeConvert.class);

    PageResult<NoticeRespVO> convertPage(PageResult<NoticeDO> page);

    NoticeRespVO convert(NoticeDO bean);

    NoticeDO convert(NoticeUpdateReqVO bean);

    NoticeDO convert(NoticeCreateReqVO bean);

}
