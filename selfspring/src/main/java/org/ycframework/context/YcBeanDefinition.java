package org.ycframework.context;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Description: YcBeanDefinition
 * Author: heyv
 * Time: 2023 2023/7/27 17:08
 * 对一个bean特征的包装的类
 *  特征：scope: ( singleton / prototype/.....) 是否是单例
 *      lazy( true/false ) 懒加载
 *      primary :主实例  多个实现类 优先注入Bean
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class YcBeanDefinition {
    //是否是懒加载
    private boolean isLazy;
    //是否是单例构造
    private  String scope="singleton";
    //是否被表明是主实例
    private boolean isprimary;
    //需要被托管的类名
    private String classInfo;

}
