package bean.property.test5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static bean.Print.println1;

/**
 * @author wangxiaohu
 * @version Id: C1_PropertiesFactoryBean1.java, v0.1 2022年03月21日 17:43:28 wangxiaohu Exp $
 * PropertiesFactoryBean:配置文件加载，xml配置使用
 *    <bean id="constantsProperties" class="org.springframework.beans.factory.config.PropertiesFactoryBean">
 *      <property >...</property>
 *    </bean>
 * 代码中使用
 *      @Resource(name = "constantsProperties")
 *      private Properties constantsProperties;
 */
public class PropertiesFactoryBeanTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean/property/test5/spring.xml");

        UserVo userVo = (UserVo)ctx.getBean("userVo");
        println1("userVo="+userVo);
        println1("userVo.myproperty.user.pwd=" + userVo.getMyproperty().get("user.pwd"));

        println1("");
        UserVo2 userVo2 = (UserVo2)ctx.getBean("userVo2");
        println1("userVo2="+userVo2);
        println1("userVo2.myproperty1.user.pwd=" + userVo2.getMyproperty1().get("user.pwd"));
        println1("userVo2.myproperty2.user.pwd=" + userVo2.getMyproperty2().get("user.pwd"));


    }
}
