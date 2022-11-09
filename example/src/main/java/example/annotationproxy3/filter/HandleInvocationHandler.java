package example.annotationproxy3.filter;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author wangxh
 * @date 2022/11/8 2:25 PM
 */
public class HandleInvocationHandler implements InvocationHandler {
    private BizHandle bean;
    private List<BizFilter> filters;
    public HandleInvocationHandler(BizHandle bean, List<BizFilter> filters){
        this.bean = bean;
        this.filters = filters;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("PcpFilterChainInvocationHandler.invoke");
        BizFilterChain filterChain = new BizFilterChain(bean, filters);
        filterChain.doFilter((BizRequest) args[0]);
        return null;
    }
}
