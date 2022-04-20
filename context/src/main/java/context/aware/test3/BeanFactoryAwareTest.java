package context.aware.test3;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanFactoryAware接口，可以实现它setBeanFactory(BeanFactory beanFactory)
 * 获取到beanFactory，BeanFactory可以调用容器的服务
 */
public class BeanFactoryAwareTest implements BeanFactoryAware {
    private static BeanFactory beanFactory;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:context/aware/test3/spring.xml");
        BeanFactoryAwareTest bean = (BeanFactoryAwareTest)beanFactory.getBean("test");
        bean.addUser();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("进入BeanFactoryAware#setBeanFactory");
        this.beanFactory=beanFactory;
    }

    private void addUser(){
        System.out.println("addUser");
    }
}
