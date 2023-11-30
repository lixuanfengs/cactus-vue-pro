package cn.cactus.framework.common.util.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Package: cn.cactus.framework.common.util
 * Description:
 * {@link CollectionUtils} 的单元测试
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/10 10:34
 * @Github https://github.com/lixuanfengs
 */
@Slf4j
public class CollectionsTest {

    @Data
    @AllArgsConstructor
    private static class Dog {

        private Integer id;
        private String name;
        private String code;

    }

    @Test
    public void testDiffList() {
        // 准备参数
        Collection<Dog> oldList = Arrays.asList(
                new Dog(1, "花花", "hh"),
                new Dog(2, "旺财", "wc")
        );
        Collection<Dog> newList = Arrays.asList(
                new Dog(null, "花花2", "hh"),
                new Dog(null, "小白", "xb")
        );
        BiFunction<Dog, Dog, Boolean> sameFunc = (oldObj, newObj) -> {
            boolean same = oldObj.getCode().equals(newObj.getCode());
            // 如果相等的情况下，需要设置下 id，后续好更新
            if (same) {
                newObj.setId(oldObj.getId());
            }
            return same;
        };

        // 调用
        List<List<Dog>> result = CollectionUtils.diffList(oldList, newList, sameFunc);
        // 断言
        assertEquals(result.size(), 3);
        // 断言 create
        assertEquals(result.get(0).size(), 1);
        assertEquals(result.get(0).get(0), new Dog(null, "小白", "xb"));
        // 断言 update
        assertEquals(result.get(1).size(), 1);
        assertEquals(result.get(1).get(0), new Dog(1, "花花2", "hh"));
        // 断言 delete
        assertEquals(result.get(2).size(), 1);
        assertEquals(result.get(2).get(0), new Dog(2, "旺财", "wc"));
    }

    @Test
    public void testFindFirst() {

        List<Dog> from =Arrays.asList(new Dog(1, "花花2", "hh"),
                new Dog(2, "旺财", "wc"),
                new Dog(3, "小白", "xb"));

        Predicate<Dog> predicate = (Dog dog) -> {

            return dog.getCode().equals("小白");
        };

        Function<Dog, String> dfun = Dog::getName;

        String firstName = CollectionUtils.findFirst(from, predicate, dfun);
        log.info("firstName : {}", firstName);
    }

    @Test
    public void testGetSumValue() {
        List<Integer> from = Arrays.asList(1, 2, 3, 4, 5);

        Function<Integer, Integer> fun = (Integer in) -> {
            return in;
        };

//        BinaryOperator<Integer> operator = (Integer v1, Integer v2) -> {
//          return v1 + v2;
//        };

        BinaryOperator<Integer> operator = (Integer v1, Integer v2) ->  v1 + v2;

        Integer sumValue = CollectionUtils.getSumValue(from, fun, operator);
        log.info("sumValue : {}", sumValue);

    }
}
