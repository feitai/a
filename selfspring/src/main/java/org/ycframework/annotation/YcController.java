package org.ycframework.annotation;

import org.springframework.stereotype.Controller;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Description: YcController
 * Author: heyv
 * Time: 2023 2023/7/27 15:20
 */
@Target(ElementType.TYPE)
@Retention( RetentionPolicy.RUNTIME )
@YcComponent
public @interface YcController {
}
