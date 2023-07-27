package org.ycframework.annotation;

import javax.annotation.Resource;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Description: YcResource
 * Author: heyv
 * Time: 2023 2023/7/27 15:46
 */
@Target({TYPE, FIELD, METHOD})
@Retention(RUNTIME)
@Resource
public @interface YcResource {



    String name();
}
