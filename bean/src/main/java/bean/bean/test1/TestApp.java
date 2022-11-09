package bean.bean.test1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangxh
 * @date 2022/11/8 4:20 PM
 */
public class TestApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext("bean.bean.test1");
    }
}
