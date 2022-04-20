package bean.property.test4_1;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class User implements FactoryBean, InitializingBean {
    private String version;
    public void init(){
        System.out.println("init...");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet...");
        init();
    }

    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    public void setVersion(String version) {
        System.out.println("setVersion...:"+version);
        this.version = version;
    }
}
