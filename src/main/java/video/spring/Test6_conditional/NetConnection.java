package video.spring.Test6_conditional;

import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Component;

/**
 * Description: NetConnection
 * Author: heyv
 * Time: 2023 2023/7/26 16:47
 */
@Component
@Conditional( {SystemCondition.class})   //条件托管

public class NetConnection {

}
