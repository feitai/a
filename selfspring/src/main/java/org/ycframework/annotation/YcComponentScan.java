package org.ycframework.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: ComponentScan
 * Author: heyv
 * Time: 2023 2023/7/27 15:05
 */

@Retention( RetentionPolicy.RUNTIME )
@Target( ElementType.TYPE)
public @interface YcComponentScan {
    String[] basePackage() default {};
}
