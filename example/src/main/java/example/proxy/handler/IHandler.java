package example.proxy.handler;

import java.lang.reflect.Method;

public interface IHandler {
    /**
     *
     * @param proxied 被代理的原始对象
     * @param proxy 代理
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    Object doHandler(Object proxied, Object proxy, Method method, Object[] args) throws Throwable;
}
