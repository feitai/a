package org.ycframework.annotation;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.*;

/**
 * Description: YcQualifier
 * Author: heyv
 * Time: 2023 2023/7/27 15:22
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention( RetentionPolicy.RUNTIME )
@Inherited
public @interface YcQualifier {
    String value() default "";
}
