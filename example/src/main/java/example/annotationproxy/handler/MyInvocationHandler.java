package example.annotationproxy.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk动态代理接口的实现
 */
public class MyInvocationHandler implements InvocationHandler {
    private Object proxied;
    private IHandler handler;
    public MyInvocationHandler(Object proxied,IHandler handler){
        this.proxied=proxied;
        this.handler=handler;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("  ++动态代理MyInvocationHandler#invoke开始:"+method.getName());
        Object obj = null;
        if(method.getName().equals("toString")
                || method.getName().equals("hashCode")
                || method.getName().equals("equals")) {
            obj = method.invoke(proxied, args);
        }else {
            obj = handler.doHandler(proxied, proxy, method, args);
        }
        System.out.println("  ++动态代理MyInvocationHandler#invoke结束:"+method.getName());
        return obj;
    }
}
