package bean.property.test7;

import static bean.Print.*;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author wangxiaohu
 * @version Id: B_MyPropertiesFactoryBean1.java, v0.1 2022年03月21日 17:43:28 wangxiaohu Exp $
 * 继承PropertiesFactoryBean重写loadProperties，可以对属性配置进行加工，例如value是加密的，读到代码中先解密，再使用
 */
public class CustomPropertiesFactoryBean extends PropertiesFactoryBean {
    @Override
    protected void loadProperties(Properties props) throws IOException {println1("重写 PropertiesFactoryBean.loadProperties");
        super.loadProperties(props);
        Set<Object> keys = props.keySet();
        for(Object key:keys){
            Object value = props.get(key);

            if(value.toString().startsWith("sec")){
                value = "重新赋值123";
                props.put(key,value);
            }

        }
    }

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:bean/property/test7/spring.xml");

        UserVo userVo = (UserVo)ctx.getBean("userVo");
        println1("userVo.myproperty.user.pwd=" + userVo.getMyproperty().get("user.pwd"));

    }
}
