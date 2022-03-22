package bean.property.test1;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wangxiaohu
 * @version Id: AppleVo.java, v0.1 2022年03月21日 11:54:23 wangxiaohu Exp $
 */
@Component
public class UserVo2 {
    @Value("${user.name}")
    private String name;
    @Value("${user.age}")
    private Integer age;
    @Value("${user.pwd}")
    private String pwd;

    @Override
    public String toString() {
        return "name="+name+",age="+age+",pwd="+pwd;
    }
}
