package example.annotationproxy3.biz.filter;

import example.annotationproxy3.annotation.BizFilterBean;
import example.annotationproxy3.filter.BizFilter;
import example.annotationproxy3.filter.BizFilterChain;
import example.annotationproxy3.filter.BizRequest;

/**
 * @author wangxh
 * @date 2022/11/7 3:11 PM
 */
//@Component
@BizFilterBean
public class ValidBlackListFilter extends BizFilter {

    @Override
    public void doFilter(BizRequest request, BizFilterChain filterChain) {
        System.out.println("ValidBlackListFilter.doFilter");
        if(request.getUserName().equals("123")){
            System.out.println("  ValidBlackListFilter.doFilter failed");
        }else{
            filterChain.doFilter(request);
        }
    }
}
