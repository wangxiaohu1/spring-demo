package bean.property.test6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static bean.Print.println1;

/**
 * @author wangxiaohu
 * @version Id: A_PropertyPlaceholderConfigurer2_tag.java, v0.1 2022年03月21日 14:17:26 wangxiaohu Exp $
 * <util:properties id="myproperty" location="prop.properties">: 创建1个Properties实例，id为myproperty，将prop.properties配置加载这个这个实例中
 * 代码中使用方法是
 *    @Resource(name="myproperty")
 *    private Properties myproperty;
 *
 *    或
 *    @Value("#{myproperty}")
 *    private Properties myproperty;
 */
public class TagTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean/property/test6/spring.xml");
        AppleVo appleVo = (AppleVo)ctx.getBean("appleVo");
        println1("appleVo1:" + appleVo);

        println1("");
        AppleVo2 appleVo2 = (AppleVo2)ctx.getBean("appleVo2");
        println1("appleVo2:" + appleVo2);

        println1("appleVo2.myproperty1.apple.year="+ appleVo2.getMyproperty1().get("apple.year"));
        println1("appleVo2.myproperty2.apple.year="+ appleVo2.getMyproperty2().get("apple.year"));
    }
}
