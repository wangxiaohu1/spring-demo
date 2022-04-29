package util;

import org.springframework.aop.framework.AdvisedSupport;
import org.springframework.aop.framework.AopProxy;
import org.springframework.aop.support.AopUtils;

import java.lang.reflect.Field;

/**
 * aop 代理工具类
 */
public class MyAopProxyUtil {
    /**
     * 返回代理类对象最底层的真实类对象
     *
     * @param proxied 代理类对象
     * @return 真实类对象
     * @throws Throwable
     */
    public static Object getRealTarget(Object proxied) throws Throwable {
        Object lastTarget = proxied;
        Object target = null;
        while(true) {
            target = getTarget(lastTarget);
            if (lastTarget == target) {
                break;
            }
            lastTarget = target;
            target = null;
        }
        return target;
    }

    /**
     * 获取 目标对象
     */
    public static Object getTarget(Object proxy) throws Exception {
        if (!AopUtils.isAopProxy(proxy)) {
            return proxy;//不是代理对象
        }
        if (AopUtils.isJdkDynamicProxy(proxy)) {
            return getJdkDynamicProxyTargetObject(proxy);
        } else { //cglib
            return getCglibProxyTargetObject(proxy);
        }
    }

    /**
     * 处理cglib
     * @param proxy
     * @return
     * @throws Exception
     */
    private static Object getCglibProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getDeclaredField("CGLIB$CALLBACK_0");
        h.setAccessible(true);
        Object advisedInterceptor = h.get(proxy);
        Field advised = advisedInterceptor.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        Object target = ((AdvisedSupport) advised.get(advisedInterceptor)).getTargetSource()
                .getTarget();
        return target;
    }

    /**
     * 处理jdk
     * @param proxy
     * @return
     * @throws Exception
     */
    private static Object getJdkDynamicProxyTargetObject(Object proxy) throws Exception {
        Field h = proxy.getClass().getSuperclass().getDeclaredField("h");
        h.setAccessible(true);
        AopProxy aopProxy = (AopProxy) h.get(proxy);
        Field advised = aopProxy.getClass().getDeclaredField("advised");
        advised.setAccessible(true);
        Object target = ((AdvisedSupport) advised.get(aopProxy)).getTargetSource().getTarget();
        return target;
    }
}
