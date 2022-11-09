package example.annotationproxy.handler;

import java.lang.reflect.Method;

/**
 * 日志处理器
 */
public class LogHandler implements IHandler{
    private IHandler nextHandler;
    public LogHandler(IHandler nextHandler){
        this.nextHandler=nextHandler;
    }
    @Override
    public Object doHandler(Object proxied, Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("    +++打日志LogHandler#doHandler开始");
        Object obj = null;
        if(nextHandler!=null){
            obj = nextHandler.doHandler(proxied,proxy,method,args);
        }else{
            obj = method.invoke(proxied,args);
        }
        System.out.println("    +++打日志LogHandler#doHandler结束");

        return obj;
    }
}
