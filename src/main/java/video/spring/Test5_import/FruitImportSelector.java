package video.spring.Test5_import;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import video.spring.Test3_factoryBean.Pear;

/**
 * Description: FruitImportSelector
 * Author: heyv
 * Time: 2023 2023/7/26 16:08
 */
public class FruitImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        //TODO: 扫描一些jar包 配置文件  --》指定的第三方的类的路径   唱用于框架
     return new String[] {Pear.class.getName()};
     }
}
