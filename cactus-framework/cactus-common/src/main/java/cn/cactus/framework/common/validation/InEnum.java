package cn.cactus.framework.common.validation;

import cn.cactus.framework.common.core.IntArrayValuable;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * Package: cn.cactus.framework.common.validation
 * Description:
 *
 * @Author 仙人球⁶ᴳ | 微信：Cactusesli
 * @Date 2023/11/10 10:27
 * @Github https://github.com/lixuanfengs
 */
@Target({
        ElementType.METHOD,
        ElementType.FIELD,
        ElementType.ANNOTATION_TYPE,
        ElementType.CONSTRUCTOR,
        ElementType.PARAMETER,
        ElementType.TYPE_USE
})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {InEnumValidator.class, InEnumCollectionValidator.class}
)
public @interface InEnum {

    /**
     * @return 实现 EnumValuable 接口的
     */
    Class<? extends IntArrayValuable> value();

    String message() default "必须在指定范围 {value}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
