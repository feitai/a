package org.ycframework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: YcBean
 * Author: heyv
 * Time: 2023 2023/7/27 15:38
 */
@Target( {ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention( RetentionPolicy.RUNTIME )
@interface YcBean {
    String [] value() default {};  //用于修改在spring的容器名
    String [] name () default {};
}
