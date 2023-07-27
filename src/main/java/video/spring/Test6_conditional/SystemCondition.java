package video.spring.Test6_conditional;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Enumeration;

/**
 * Description: SystemCondition
 * Author: heyv
 * Time: 2023 2023/7/26 16:48
 */
public class SystemCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
      Environment env = conditionContext.getEnvironment();

      //环境变量的记载顺序，    1.系统变量  os.naee
        //                   命令参数  ：os.name = Linux
        //                   程序
      String osName=env.getProperty("os.name");
        System.out.println(osName);
        if(osName.contains("Windows")) {
            return true;
        }else {
            return false;
        }

    }
}
