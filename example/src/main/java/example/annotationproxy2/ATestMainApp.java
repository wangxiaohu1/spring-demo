package example.annotationproxy2;

import example.annotationproxy2.service.UserManagerFacadeImpl;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangxh
 * @date 2022/11/8 4:20 PM
 */
public class ATestMainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("example.annotationproxy2");
        UserManagerFacadeImpl facade = applicationContext.getBean(UserManagerFacadeImpl.class);
        facade.queryUserByName("123");
    }
}
