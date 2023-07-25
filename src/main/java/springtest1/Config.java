package springtest1;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Description: Config
 * Author: heyv
 * Time: 2023 2023/7/25 16:40
 */
@Configuration  //此类是一个配置类，声明容器运行时一些配置信息，也会被Spring托管
@ComponentScan(basePackages = {"springtest1"})//声明扫描的路径
public class Config {

}
