package bean.property.test5;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wangxiaohu
 * @version Id: AppleVo.java, v0.1 2022年03月21日 11:54:23 wangxiaohu Exp $
 */
@Component
public class UserVo2 {

    @Resource(name = "myproperty")
    private Properties myproperty1;

    @Value("#{myproperty}")
    private Properties myproperty2;

    @Value("#{myproperty['user.name']}")
    private String name;
    @Value("#{myproperty['user.age']}")
    private Integer age;

    public Properties getMyproperty1() {
        return myproperty1;
    }

    public Properties getMyproperty2() {
        return myproperty2;
    }

    @Override
    public String toString() {
        return "name="+name+",age="+age;
    }
}
