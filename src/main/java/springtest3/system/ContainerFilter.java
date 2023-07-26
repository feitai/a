package springtest3.system;

/**
 * Description: ContainerFilter
 * Author: heyv
 * Time: 2023 2023/7/26 8:41
 */
public interface ContainerFilter<T> {

    public boolean doFilter(Object obj);

}
