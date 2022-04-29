package example.proxy;

import example.proxy.service.api.UserQueryAPI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 启动测试类
 * 这个案例:使用spring BeanPostProcessor和jdk动态代理技术对 spirng bean进行增强
 */
public class AppRunTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:example/proxy/spring.xml");
        UserQueryAPI api = (UserQueryAPI)ctx.getBean(UserQueryAPI.class);
        System.out.println("AppRunTest#main 结果:"+api.queryNameById(1l));
    }
}
