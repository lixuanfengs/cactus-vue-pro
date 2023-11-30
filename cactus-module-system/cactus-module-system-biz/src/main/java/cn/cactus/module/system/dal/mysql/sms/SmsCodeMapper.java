package cn.cactus.module.system.dal.mysql.sms;

import cn.cactus.framework.mybatis.core.mapper.BaseMapperX;
import cn.cactus.framework.mybatis.core.query.QueryWrapperX;
import cn.cactus.module.system.dal.dataobject.sms.SmsCodeDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * Package: cn.cactus.module.system.dal.mysql.sms
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/22 16:23
 * @Github https://github.com/lixuanfengs
 */
@Mapper
public interface SmsCodeMapper extends BaseMapperX<SmsCodeDO> {

    /**
     * 获得手机号的最后一个手机验证码
     *
     * @param mobile 手机号
     * @param scene 发送场景，选填
     * @param code 验证码 选填
     * @return 手机验证码
     */
    default SmsCodeDO selectLastByMobile(String mobile, String code, Integer scene) {
        return selectOne(new QueryWrapperX<SmsCodeDO>()
                .eq("mobile", mobile)
                .eqIfPresent("scene", scene)
                .eqIfPresent("code", code)
                .orderByDesc("id")
                .limitN(1));
    }

}

