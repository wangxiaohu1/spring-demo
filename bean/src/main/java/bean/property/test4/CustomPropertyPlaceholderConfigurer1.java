package bean.property.test4;

import static bean.Print.*;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangxiaohu
 * @version Id: MyPropertyPlaceholderConfigurer1.java, v0.1 2022年03月21日 11:18:53 wangxiaohu Exp $
 * 继承PropertyPlaceholderConfigurer，重写convertProperty方法，可以对属性的key-value进行重新处理
 */
public class CustomPropertyPlaceholderConfigurer1 extends PropertyPlaceholderConfigurer {
    @Override
    protected String convertProperty(String propertyName, String propertyValue) {
        println1("重写convertProperty,"+propertyName+" = " + propertyValue);
        if(propertyValue.startsWith("sec")){
            propertyValue = "重新赋值1234";
        }
        return super.convertProperty(propertyName, propertyValue);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean/property/test4/spring1.xml");
        UserVo userVo = (UserVo)ctx.getBean("userVo");
        println1("userVo1:" + userVo);

        UserVo2 userVo2 = (UserVo2)ctx.getBean("userVo2");
        println1("userVo2:" + userVo2);


    }
}
