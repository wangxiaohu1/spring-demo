package context.aware.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * MessageSourceAware:获得message source，这也可以获得文本信息
 */
public class MessageSourceAwareTest implements MessageSourceAware {
    private static MessageSource messageSource;
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:context/aware/test3/spring.xml");
    }
    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("进入MessageSourceAware#setMessageSource");
        this.messageSource=messageSource;
    }
}
