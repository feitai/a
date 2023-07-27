package video.spring.Test4_annotation;

/**
 * Description: PeroductBiz
 * Author: heyv
 * Time: 2023 2023/7/26 15:03
 */
public interface PeroductBiz {
    public void  takein(); //入库操作，先查再添  (a.首先find（） 然后可能是 update（）或者 add（）)

}
