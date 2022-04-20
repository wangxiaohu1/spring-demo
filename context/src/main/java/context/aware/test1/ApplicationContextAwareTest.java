package context.aware.test1;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Aware接口：使用了spring Aware 你的bean将会和spring框架耦合，spring aware 的目的是为了让bean获取spring容器的服务
 *
 * spring 提供的aware的接口：
 *   BeanNameAware ：可以获取容器中bean的名称
 *   BeanFactoryAware:获取当前bean factory这也可以调用容器的服务
 *   ApplicationContextAware： 当前的applicationContext， 这也可以调用容器的服务
 *   MessageSourceAware：获得message source，这也可以获得文本信息
 *   applicationEventPulisherAware：应用事件发布器，可以发布事件，
 *   ResourceLoaderAware： 获得资源加载器，可以获得外部资源文件的内容
 *
 *   例如：ApplicationContextAware: 实现它setApplicationContext(ApplicationContext applicationContext)方法，
 *   获得spring applicationContext，就可以调用容器的如无，最常将就是在静态方法中通过applicationContext获取bean
 */
public class ApplicationContextAwareTest implements ApplicationContextAware {
    private ApplicationContext applicationContext;
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:context/aware/test1/spring.xml");
        System.out.println("从上下文工具ApplicationContextUtils获得bean");
        ApplicationContextAwareTest test = (ApplicationContextAwareTest) ApplicationContextUtil.getBean("Test");
        UserService userService = (UserService)ApplicationContextUtil.getBean("userService");

        System.out.println("  "+test);
        System.out.println("  "+userService);
    }

    public void init(){
        System.out.println("step2,进入init, 从applicationContext获取所有的bean并打印");
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for(String beanName : beanNames) {
            Object bean = applicationContext.getBean(beanName);
            System.out.println("  "+bean);
        }
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("step1,进入setApplicationContext...");
        this.applicationContext = applicationContext;
        System.out.println("  将applicationContext对象设置到工具类ApplicationContextUtils");
        ApplicationContextUtil.setApplicationContext(applicationContext);
    }




}
