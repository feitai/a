package org.ycframework.context;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Description: YcApplicationContext
 * Author: heyv
 * Time: 2023 2023/7/27 15:59
 */
public interface YcApplicationContext {
    public Object getBean( String beanId);

}
