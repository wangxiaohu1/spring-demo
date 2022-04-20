package bean.property.test4_1;

import bean.property.test4.UserVo;
import bean.property.test4.UserVo2;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Properties;

import static bean.Print.println1;

/**
 *
 */
public class CustomPropertyPlaceholderConfigurer1 extends PropertyPlaceholderConfigurer {
    private MyWare myWare;
    @Override
    protected String resolvePlaceholder(String placeholder, Properties props) {
        System.out.println("resolvePlaceholder...");
        return props.getProperty(placeholder);
    }

    public void setMyWare(MyWare myWare) {
        this.myWare = myWare;
    }
}
