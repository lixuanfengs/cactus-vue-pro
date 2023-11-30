package cn.cactus.module.system.dal.mysql.mail;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.cactus.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import cn.cactus.module.system.dal.dataobject.mail.MailAccountDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Package: cn.cactus.module.system.dal.mysql.mail
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:16
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface MailAccountMapper extends BaseMapperX<MailAccountDO> {

    default PageResult<MailAccountDO> selectPage(MailAccountPageReqVO pageReqVO) {
        return selectPage(pageReqVO, new LambdaQueryWrapperX<MailAccountDO>()
                .likeIfPresent(MailAccountDO::getMail, pageReqVO.getMail())
                .likeIfPresent(MailAccountDO::getUsername , pageReqVO.getUsername()));
    }

}

