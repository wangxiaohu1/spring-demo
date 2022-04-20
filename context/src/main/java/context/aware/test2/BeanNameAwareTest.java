package context.aware.test2;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * BeanNameAware:可以获取容器中bean的名称
 */
public class BeanNameAwareTest implements BeanNameAware {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:context/aware/test2/spring.xml");
    }

    public void init(){
        System.out.println("进入init...");
    }
    @Override
    public void setBeanName(String name) {
        System.out.println("进入setBeanName....,"+ name);
    }
}
