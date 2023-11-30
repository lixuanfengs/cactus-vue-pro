package cn.cactus.module.system.service.notice;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.notice.vo.NoticeCreateReqVO;
import cn.cactus.module.system.controller.admin.notice.vo.NoticePageReqVO;
import cn.cactus.module.system.controller.admin.notice.vo.NoticeUpdateReqVO;
import cn.cactus.module.system.convert.notice.NoticeConvert;
import cn.cactus.module.system.dal.dataobject.notice.NoticeDO;
import cn.cactus.module.system.dal.mysql.notice.NoticeMapper;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static cn.cactus.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.cactus.module.system.enums.ErrorCodeConstants.NOTICE_NOT_FOUND;

/**
 * Package: cn.cactus.module.system.service.notice
 * Description:
 * 通知公告 Service 实现类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 15:31
 * @Github https://github.com/lixuanfengs
 */
@Service
public class NoticeServiceImpl implements NoticeService {

    @Resource
    private NoticeMapper noticeMapper;

    @Override
    public Long createNotice(NoticeCreateReqVO reqVO) {
        NoticeDO notice = NoticeConvert.INSTANCE.convert(reqVO);
        noticeMapper.insert(notice);
        return notice.getId();
    }

    @Override
    public void updateNotice(NoticeUpdateReqVO reqVO) {
        // 校验是否存在
        validateNoticeExists(reqVO.getId());
        // 更新通知公告
        NoticeDO updateObj = NoticeConvert.INSTANCE.convert(reqVO);
        noticeMapper.updateById(updateObj);
    }

    @Override
    public void deleteNotice(Long id) {
        // 校验是否存在
        validateNoticeExists(id);
        // 删除通知公告
        noticeMapper.deleteById(id);
    }

    @Override
    public PageResult<NoticeDO> getNoticePage(NoticePageReqVO reqVO) {
        return noticeMapper.selectPage(reqVO);
    }

    @Override
    public NoticeDO getNotice(Long id) {
        return noticeMapper.selectById(id);
    }

    @VisibleForTesting
    public void validateNoticeExists(Long id) {
        if (id == null) {
            return;
        }
        NoticeDO notice = noticeMapper.selectById(id);
        if (notice == null) {
            throw exception(NOTICE_NOT_FOUND);
        }
    }

}

