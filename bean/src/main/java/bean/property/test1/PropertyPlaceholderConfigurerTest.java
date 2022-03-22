package bean.property.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static bean.Print.println1;

/**
 * @author wangxiaohu
 * @version Id: A_PropertyPlaceholderConfigurer.java, v0.1 2022年03月21日 14:01:53 wangxiaohu Exp $
 * PropertyPlaceholderConfigurer它能够对<bean/>中的属性值进行外在化管理。开发者可以提供单独的属性文件来管理相关属性
 */
public class PropertyPlaceholderConfigurerTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean/property/test1/spring.xml");
        UserVo userVo = (UserVo)ctx.getBean("userVo");
        println1("userVo1:" + userVo);

        UserVo2 userVo2 = (UserVo2)ctx.getBean("userVo2");
        println1("userVo2:" + userVo2);
    }
}
