package bean.property.test2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static bean.Print.println1;

/**
 * @author wangxiaohu
 * @version Id: A_PropertyPlaceholderConfigurer2_tag.java, v0.1 2022年03月21日 14:17:26 wangxiaohu Exp $
 * <context:property-placeholder/>元素: 为简化PropertyPlaceholderConfigurer的使用，Spring提供了<context:property-placeholder/>元素
 */
public class TagTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean/property/test2/spring.xml");
        UserVo userVo = (UserVo)ctx.getBean("userVo");
        println1("userVo1:" + userVo);

        UserVo2 userVo2 = (UserVo2)ctx.getBean("userVo2");
        println1("userVo2:" + userVo2);
    }
}
