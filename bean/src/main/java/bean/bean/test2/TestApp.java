package bean.bean.test2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangxh
 * @date 2022/11/9 10:16 AM
 */
public class TestApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("bean.bean.test2");
        UserServiceImpl userService = applicationContext.getBean(UserServiceImpl.class);
        System.out.println("userService:"+userService);
    }

}
