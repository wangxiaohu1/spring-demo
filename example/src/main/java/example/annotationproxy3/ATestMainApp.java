package example.annotationproxy3;

import example.annotationproxy2.service.UserInfo;
import example.annotationproxy3.biz.facade.FacadeImpl;
import example.annotationproxy3.filter.BizRequest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;


/**
 * @author wangxh
 * @date 2022/11/8 10:22 AM
 */
@CustomAnnotationScan(scanPackage = {"example.annotationproxy3"})
public class ATestMainApp {
    public static void main(String[] args) {

        // 基于注解的容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ATestMainApp.class);

        System.out.println("不通过测试");
        FacadeImpl facade = applicationContext.getBean(FacadeImpl.class);
        BizRequest request = new BizRequest("123");
        facade.test(request);


        System.out.println("\n通过测试");
        facade = applicationContext.getBean(FacadeImpl.class);
        request = new BizRequest("1234");
        facade.test(request);

    }
}
