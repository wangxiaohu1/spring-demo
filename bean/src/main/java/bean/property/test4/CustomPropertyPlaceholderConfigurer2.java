package bean.property.test4;

import java.util.Properties;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static bean.Print.println1;

/**
 * @author wangxiaohu
 * @version Id: MyPropertyPlaceholderConfigurer1, v0.1 2022年03月21日 11:18:53 wangxiaohu Exp $
 * 继承PropertyPlaceholderConfigurer，重写processProperties方法，可以对属性的key-value进行重新处理
 */
public class CustomPropertyPlaceholderConfigurer2 extends PropertyPlaceholderConfigurer {

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
        throws BeansException {
        println1("重写 processProperties");
        Set<Object> keys = props.keySet();
        for(Object key:keys){
            Object value = props.get(key);
            println1(key+"="+value);

            if(value.toString().startsWith("sec")){
                value = "重新赋值123";
            }
            props.put(key,value);
        }

        super.processProperties(beanFactoryToProcess, props);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean/property/test4/spring2.xml");
        UserVo userVo = (UserVo)ctx.getBean("userVo");
        println1("userVo1:" + userVo);

        UserVo2 userVo2 = (UserVo2)ctx.getBean("userVo2");
        println1("userVo2:" + userVo2);

    }
}
