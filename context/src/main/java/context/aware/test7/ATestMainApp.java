package context.aware.test7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author wangxh
 * @date 2022/11/8 10:22 AM
 */
@CustomAnnotationScan(scanPackage = {"context.aware.test7"})
public class ATestMainApp {
    public static void main(String[] args) {

        // 基于注解的容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ATestMainApp.class);
        UserServiceImpl bean = applicationContext.getBean(UserServiceImpl.class);
        System.out.println(bean);
    }
}
