package cn.cactus.framework.mybatis.core.type;

import cn.cactus.framework.common.util.json.JsonUtils;
import com.baomidou.mybatisplus.extension.handlers.AbstractJsonTypeHandler;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.Set;

/**
 * Package: cn.cactus.framework.mybatis.core.type
 * Description:
 * 参考 {@link com.baomidou.mybatisplus.extension.handlers.JacksonTypeHandler} 实现
 * 在我们将字符串反序列化为 Set 并且泛型为 Long 时，如果每个元素的数值太小，会被处理成 Integer 类型，导致可能存在隐性的 BUG。
 *
 * 例如说哦，SysUserDO 的 postIds 属性
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/14 16:46
 * @Github https://github.com/lixuanfengs
 */
public class JsonLongSetTypeHandler extends AbstractJsonTypeHandler<Object> {

    private static final TypeReference<Set<Long>> TYPE_REFERENCE = new TypeReference<Set<Long>>(){};


    @Override
    protected Object parse(String json) {
        return JsonUtils.parseObject(json, TYPE_REFERENCE);
    }

    @Override
    protected String toJson(Object obj) {
        return JsonUtils.toJsonString(obj);
    }
}
