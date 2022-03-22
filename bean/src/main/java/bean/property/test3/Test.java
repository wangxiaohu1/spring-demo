package bean.property.test3;

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
 * PropertyPlaceholderConfigurer 和 <context:property-placeholder>标签同时存在的时候，只会按照spring配置来加载第1个配置，会忽略其他配置文件
 * 例如下面的配置，就只会加载context:property-placeholder配置的prop1.properties，不会加载id=myProperty这个bean配置的prop2.properties
 * 也就是是prop1.properties中有a,b两个key,prop2.properties有c,d两个key，最终加载后就只会加载prop1.properties中有a,b两个key
 *      配置1
 *  	<context:property-placeholder location="classpath:bean/test3/prop1.properties"/>
 *      配置2
 *      <bean id="myProperty" class="bean.property.test3.A_MyPropertyPlaceholderConfigurer1">
 * 		<property name="locations">
 * 			<list>
 * 				<value>bean/test3/prop2.properties</value>
 * 			</list>
 * 		</property>
 * 	</bean>
 */
public class Test extends PropertyPlaceholderConfigurer {
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props)
        throws BeansException {
        println1("重写 PropertyPlaceholderConfigurer.processProperties");
        Set<Object> keys = props.keySet();
        for(Object key:keys){
            Object value = props.get(key);

            if(value.toString().startsWith("sec")){
                value = "重新赋值123";
                println1(key+"="+value);
            }
            props.put(key,value);
        }

        super.processProperties(beanFactoryToProcess, props);
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean/property/test3/spring.xml");
        TagVo tagVo = (TagVo)ctx.getBean("tagVo");
        println1("tagVo1:" + tagVo);

        TagVo2 tagVo2 = (TagVo2)ctx.getBean("tagVo2");
        println1("tagVo2:" + tagVo2);

    }
}
