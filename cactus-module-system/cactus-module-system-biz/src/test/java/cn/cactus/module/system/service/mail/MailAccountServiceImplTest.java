package cn.cactus.module.system.service.mail;

import cn.cactus.framework.common.pojo.PageResult;
import cn.cactus.framework.test.core.ut.BaseDbUnitTest;
import cn.cactus.module.system.controller.admin.mail.vo.account.MailAccountCreateReqVO;
import cn.cactus.module.system.controller.admin.mail.vo.account.MailAccountPageReqVO;
import cn.cactus.module.system.controller.admin.mail.vo.account.MailAccountUpdateReqVO;
import cn.cactus.module.system.dal.dataobject.mail.MailAccountDO;
import cn.cactus.module.system.dal.mysql.mail.MailAccountMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;

import javax.annotation.Resource;
import java.util.List;

import static cn.cactus.framework.common.util.object.ObjectUtils.cloneIgnoreId;
import static cn.cactus.framework.test.core.util.AssertUtils.assertPojoEquals;
import static cn.cactus.framework.test.core.util.AssertUtils.assertServiceException;
import static cn.cactus.framework.test.core.util.RandomUtils.*;
import static cn.cactus.module.system.enums.ErrorCodeConstants.MAIL_ACCOUNT_NOT_EXISTS;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

/**
 * Package: cn.cactus.module.system.service.mail
 * Description:
 * {@link MailAccountServiceImpl} 的单元测试类
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/23 17:09
 * @Github https://github.com/lixuanfengs
 */
@Import(MailAccountServiceImpl.class)
public class MailAccountServiceImplTest extends BaseDbUnitTest {

    @Resource
    private MailAccountServiceImpl mailAccountService;

    @Resource
    private MailAccountMapper mailAccountMapper;

    @MockBean
    private MailTemplateService mailTemplateService;

    @Test
    public void testCreateMailAccount_success() {
        // 准备参数
        MailAccountCreateReqVO reqVO = randomPojo(MailAccountCreateReqVO.class, o -> o.setMail(randomEmail()));

        // 调用
        Long mailAccountId = mailAccountService.createMailAccount(reqVO);
        // 断言
        assertNotNull(mailAccountId);
        // 校验记录的属性是否正确
        MailAccountDO mailAccount = mailAccountMapper.selectById(mailAccountId);
        assertPojoEquals(reqVO, mailAccount);
    }

    @Test
    public void testUpdateMailAccount_success() {
        // mock 数据
        MailAccountDO dbMailAccount = randomPojo(MailAccountDO.class);
        mailAccountMapper.insert(dbMailAccount);// @Sql: 先插入出一条存在的数据
        // 准备参数
        MailAccountUpdateReqVO reqVO = randomPojo(MailAccountUpdateReqVO.class, o -> {
            o.setId(dbMailAccount.getId()); // 设置更新的 ID
            o.setMail(randomEmail());
        });

        // 调用
        mailAccountService.updateMailAccount(reqVO);
        // 校验是否更新正确
        MailAccountDO mailAccount = mailAccountMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, mailAccount);
    }

    @Test
    public void testUpdateMailAccount_notExists() {
        // 准备参数
        MailAccountUpdateReqVO reqVO = randomPojo(MailAccountUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> mailAccountService.updateMailAccount(reqVO), MAIL_ACCOUNT_NOT_EXISTS);
    }

    @Test
    public void testDeleteMailAccount_success() {
        // mock 数据
        MailAccountDO dbMailAccount = randomPojo(MailAccountDO.class);
        mailAccountMapper.insert(dbMailAccount);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMailAccount.getId();
        // mock 方法（无关联模版）
        when(mailTemplateService.countByAccountId(eq(id))).thenReturn(0L);

        // 调用
        mailAccountService.deleteMailAccount(id);
        // 校验数据不存在了
        assertNull(mailAccountMapper.selectById(id));
    }

    @Test
    public void testGetMailAccountFromCache() {
        // mock 数据
        MailAccountDO dbMailAccount = randomPojo(MailAccountDO.class);
        mailAccountMapper.insert(dbMailAccount);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMailAccount.getId();

        // 调用
        MailAccountDO mailAccount = mailAccountService.getMailAccountFromCache(id);
        // 断言
        assertPojoEquals(dbMailAccount, mailAccount);
    }

    @Test
    public void testDeleteMailAccount_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> mailAccountService.deleteMailAccount(id), MAIL_ACCOUNT_NOT_EXISTS);
    }

    @Test
    public void testGetMailAccountPage() {
        // mock 数据
        MailAccountDO dbMailAccount = randomPojo(MailAccountDO.class, o -> { // 等会查询到
            o.setMail("768@qq.com");
            o.setUsername("yunai");
        });
        mailAccountMapper.insert(dbMailAccount);
        // 测试 mail 不匹配
        mailAccountMapper.insert(cloneIgnoreId(dbMailAccount, o -> o.setMail("788@qq.com")));
        // 测试 username 不匹配
        mailAccountMapper.insert(cloneIgnoreId(dbMailAccount, o -> o.setUsername("tudou")));
        // 准备参数
        MailAccountPageReqVO reqVO = new MailAccountPageReqVO();
        reqVO.setMail("768");
        reqVO.setUsername("yu");

        // 调用
        PageResult<MailAccountDO> pageResult = mailAccountService.getMailAccountPage(reqVO);
        // 断言
        assertEquals(1, pageResult.getTotal());
        assertEquals(1, pageResult.getList().size());
        assertPojoEquals(dbMailAccount, pageResult.getList().get(0));
    }

    @Test
    public void testGetMailAccount() {
        // mock 数据
        MailAccountDO dbMailAccount = randomPojo(MailAccountDO.class);
        mailAccountMapper.insert(dbMailAccount);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbMailAccount.getId();

        // 调用
        MailAccountDO mailAccount = mailAccountService.getMailAccount(id);
        // 断言
        assertPojoEquals(dbMailAccount, mailAccount);
    }

    @Test
    public void testGetMailAccountList() {
        // mock 数据
        MailAccountDO dbMailAccount01 = randomPojo(MailAccountDO.class);
        mailAccountMapper.insert(dbMailAccount01);
        MailAccountDO dbMailAccount02 = randomPojo(MailAccountDO.class);
        mailAccountMapper.insert(dbMailAccount02);
        // 准备参数

        // 调用
        List<MailAccountDO> list = mailAccountService.getMailAccountList();
        // 断言
        assertEquals(2, list.size());
        assertPojoEquals(dbMailAccount01, list.get(0));
        assertPojoEquals(dbMailAccount02, list.get(1));
    }

}