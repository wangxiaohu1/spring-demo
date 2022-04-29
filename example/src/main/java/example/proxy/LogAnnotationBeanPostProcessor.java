package example.proxy;

import example.proxy.annotation.Log;
import example.proxy.handler.IHandler;
import example.proxy.handler.LogHandler;
import example.proxy.handler.MyInvocationHandler;
import org.springframework.aop.framework.AopProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import util.MyAopProxyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@Component
public class LogAnnotationBeanPostProcessor implements BeanPostProcessor {
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println(" -LogAnnotationBeanPostProcessor,beanName:"+bean);
        try {
            Object target = MyAopProxyUtil.getTarget(bean);
            Class<?> clazz = target.getClass();
            Class<?> ifClazz = null;
            Log logAnno = AnnotationUtils.findAnnotation(clazz,Log.class);
            if(logAnno!=null){
                ifClazz = logAnno.interfaceName();
                //LogHandler:日志处理器
                IHandler myHandler = new LogHandler(null);

                //java.lang.reflect.InvocationHandler
                //MyInvocationHandler: jdk动态代理的实现处理器
                //InvocationHandler myInvocationHandler = new MyInvocationHandler(target,myHandler);
                //Object proxy1 = Proxy.newProxyInstance(target.getClass().getClassLoader(), new Class[]{ifClazz}, myInvocationHandler);

                InvocationHandler myInvocationHandler = new MyInvocationHandler(bean,myHandler);
                Object proxy1 = Proxy.newProxyInstance(bean.getClass().getClassLoader(), new Class[]{ifClazz}, myInvocationHandler);
                return proxy1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return bean;
    }
}