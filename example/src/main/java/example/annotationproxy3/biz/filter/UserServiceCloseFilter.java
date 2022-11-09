package example.annotationproxy3.biz.filter;

import example.annotationproxy3.annotation.BizFilterBean;
import example.annotationproxy3.filter.BizFilter;
import example.annotationproxy3.filter.BizFilterChain;
import example.annotationproxy3.filter.BizRequest;

/**
 * @author wangxh
 * @date 2022/11/9 11:20 AM
 */
@BizFilterBean
public class UserServiceCloseFilter extends BizFilter {
    public void doFilter(BizRequest request, BizFilterChain filterChain){
        boolean close = false;
        if(close){
            return;
        }else{
            filterChain.doFilter(request);
        }
    }
}
