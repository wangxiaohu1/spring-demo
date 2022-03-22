package bean.property.test3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wangxiaohu
 * @version Id: UserVo.java, v0.1 2022年03月21日 11:43:11 wangxiaohu Exp $
 */
@Component
public class TagVo2 {
    @Value("${tag.name:默认值}")
    private String name;
    @Value("${tag.age:-1}")
    private Integer age;
    @Value("${tag.pwd:默认值}")
    private String pwd;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }


    @Override
    public String toString() {
        return "name="+name+",age="+age+",pwd="+pwd;
    }
}
