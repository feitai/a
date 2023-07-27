package org.ycframework.annotation;

import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * Description: YcComponent
 * Author: heyv
 * Time: 2023 2023/7/27 15:08
 */
@Target( ElementType.TYPE )
@Retention( RetentionPolicy.RUNTIME )

public @interface YcComponent {
    String value() default "";

}
