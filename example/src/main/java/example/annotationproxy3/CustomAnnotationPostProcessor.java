package example.annotationproxy3;

import com.google.common.collect.Lists;
import example.annotationproxy3.annotation.BizHandleBean;
import example.annotationproxy3.filter.BizFilter;
import example.annotationproxy3.filter.BizHandle;
import example.annotationproxy3.filter.HandleInvocationHandler;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import util.MyAopProxyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @author wangxh
 * @date 2022/11/8 11:32 AM
 */
@Component
public class CustomAnnotationPostProcessor implements BeanPostProcessor, BeanFactoryPostProcessor {
    private ConfigurableListableBeanFactory beanFactory;
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        // 获取bean的field中的注解信息，注入有ServiceRegisterField注解的成员
        System.out.println("bean:" + beanName + " created");
        try {
            Object target = MyAopProxyUtil.getTarget(bean);
            Class<?> clazz = target.getClass();
            Class<?> ifClazz = BizHandle.class;
            BizHandleBean annotation = AnnotationUtils.findAnnotation(clazz,BizHandleBean.class);
            List<BizFilter> pcpFilterList = Lists.newArrayList();
            if(annotation!=null){
                for(Class filterClazz : annotation.filters()){
                    BizFilter pcpFilter = (BizFilter) beanFactory.getBean(filterClazz);
                    pcpFilterList.add(pcpFilter);
                }

                InvocationHandler myInvocationHandler = new HandleInvocationHandler((BizHandle)bean,pcpFilterList);
                Object proxy1 = Proxy.newProxyInstance(bean.getClass().getClassLoader(), new Class[]{ifClazz}, myInvocationHandler);
                return proxy1;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bean;
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
        System.out.println("postProcessBeanFactory");
    }
}
