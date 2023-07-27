package org.ycframework.annotation;

import org.springframework.context.annotation.Lazy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: YcLazy
 * Author: heyv
 * Time: 2023 2023/7/27 15:25
 */
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.FIELD})
@Retention( RetentionPolicy.RUNTIME )
public @interface YcLazy {
    boolean value() default true;
}
