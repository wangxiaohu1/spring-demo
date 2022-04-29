package example.proxy.interceptor;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Component
public class MyInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {

        System.out.println("+拦截器MyInterceptor#invoke开始:" +invocation.getThis().getClass().getSimpleName() +"#" +invocation.getMethod().getName());
        Object obj = invocation.proceed();
        System.out.println("+拦截器MyInterceptor#invoke结束:" +invocation.getThis().getClass().getSimpleName() +"#" +invocation.getMethod().getName());
        return obj;
    }
}
