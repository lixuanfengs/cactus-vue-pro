package cn.cactus.module.system.service.mail;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.module.system.controller.admin.mail.vo.account.MailAccountCreateReqVO;
import cn.cactus.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import cn.cactus.module.system.controller.admin.mail.vo.account.MailAccountUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.mail.MailAccountDO;

import javax.validation.Valid;
import java.util.List;

/**
 * Package: cn.cactus.module.system.service.mail
 * Description:
 * 邮箱账号 Service 接口
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 15:21
 * @Github https://github.com/lixuanfengs
 */
public interface MailAccountService {

    /**
     * 创建邮箱账号
     *
     * @param createReqVO 邮箱账号信息
     * @return 编号
     */
    Long createMailAccount(@Valid MailAccountCreateReqVO createReqVO);

    /**
     * 修改邮箱账号
     *
     * @param updateReqVO 邮箱账号信息
     */
    void updateMailAccount(@Valid MailAccountUpdateReqVO updateReqVO);

    /**
     * 删除邮箱账号
     *
     * @param id 编号
     */
    void deleteMailAccount(Long id);

    /**
     * 获取邮箱账号信息
     *
     * @param id 编号
     * @return 邮箱账号信息
     */
    MailAccountDO getMailAccount(Long id);

    /**
     * 从缓存中获取邮箱账号
     *
     * @param id 编号
     * @return 邮箱账号
     */
    MailAccountDO getMailAccountFromCache(Long id);

    /**
     * 获取邮箱账号分页信息
     *
     * @param pageReqVO 邮箱账号分页参数
     * @return 邮箱账号分页信息
     */
    PageResult<MailAccountDO> getMailAccountPage(MailAccountPageReqVO pageReqVO);

    /**
     * 获取邮箱数组信息
     *
     * @return 邮箱账号信息数组
     */
    List<MailAccountDO> getMailAccountList();

}

