package bean.property.test4_1;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class MyWare implements ApplicationContextAware {

    public void get(){

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        applicationContext.getBean(Group.class);
        System.out.println("MyWare setApplicationContext...");
    }

}
