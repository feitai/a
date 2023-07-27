package org.ycframework.annotation;

import org.springframework.context.annotation.PropertySource;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: YcPropertySource
 * Author: heyv
 * Time: 2023 2023/7/27 15:49
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface YcPropertySource {
    String value();//表示使用了YcPropertySource时。一定要指定value值
}
