package example.annotationproxy2;

import example.annotationproxy2.annotation.ValidBlackList;
import example.annotationproxy2.service.UserService;
import example.annotationproxy2.handler.MyInvocationHandler;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import util.MyAopProxyUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * BeanPostProcessor: bean构建完成后的接口
 * @author wangxh
 * @date 2022/11/8 4:15 PM
 */
@Component
public class BeanPostProcessorTestBean implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        try {
            Object targetBean = MyAopProxyUtil.getTarget(bean);
            Class targetClass = targetBean.getClass();
            Annotation annotation = AnnotationUtils.findAnnotation(targetClass, ValidBlackList.class);
            if(annotation!=null){
                InvocationHandler myInvocationHandler = new MyInvocationHandler(bean);
                Object proxy1 = Proxy.newProxyInstance(bean.getClass().getClassLoader(), new Class[]{UserService.class}, myInvocationHandler);
                return proxy1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }
}
