package bean.property.test4_1;

import bean.property.test4.UserVo;
import bean.property.test4.UserVo2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static bean.Print.println1;

public class TestApp {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean/property/test4_1/spring1.xml");
    }
}
