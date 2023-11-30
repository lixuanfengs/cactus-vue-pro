package cn.cactus.framework.common.core;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Package: cn.cactus.framework.common.core
 * Description:
 *  Key Value 的键值对
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/9 9:23
 * @Github https://github.com/lixuanfengs
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class KeyValue<K, V> implements Serializable {

    private K key;
    private V value;

}
