package context.aware.test5;

import org.springframework.context.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * ApplicationEventPublisherAware:获取应用事件发布器，可以发布事件
 */
public class ApplicationEventPulisherAwareTest implements ApplicationEventPublisherAware {
    private static ApplicationEventPublisher applicationEventPublisher;
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:context/aware/test3/spring.xml");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("进入ApplicationEventPublisherAware#setApplicationEventPublisher");
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
