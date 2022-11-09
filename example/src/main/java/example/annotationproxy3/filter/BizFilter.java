package example.annotationproxy3.filter;

/**
 * @author wangxh
 * @date 2022/11/7 1:36 PM
 */
public abstract class BizFilter {
    public abstract void doFilter(BizRequest request, BizFilterChain filterChain);

}
