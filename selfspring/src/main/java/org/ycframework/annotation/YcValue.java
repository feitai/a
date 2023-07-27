package org.ycframework.annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: YcValue
 * Author: heyv
 * Time: 2023 2023/7/27 15:23
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE})
@Retention( RetentionPolicy.RUNTIME )
public @interface YcValue {
    String value() ; //无默认值，在使用时必须添加
}
