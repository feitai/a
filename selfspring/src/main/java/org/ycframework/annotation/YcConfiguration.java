package org.ycframework.annotation;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Indexed;

import java.lang.annotation.*;

/**
 * Description: YcConfiguration
 * Author: heyv
 * Time: 2023 2023/7/27 15:00
 */
@Target(ElementType.TYPE)
@Retention( RetentionPolicy.RUNTIME )
@YcComponent
public @interface YcConfiguration {

}
