package cn.cactus.framework.file.core.client;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * Package: cn.cactus.framework.file.core.client
 * Description:
 * 文件客户端的配置
 * 不同实现的客户端，需要不同的配置，通过子类来定义
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/24 15:50
 * @Github https://github.com/lixuanfengs
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
// @JsonTypeInfo 注解的作用，Jackson 多态
// 1. 序列化到数据库时，增加 @class 属性。
// 2. 反序列化到内存对象时，通过 @class 属性，可以创建出正确的类型
public interface FileClientConfig {
}
