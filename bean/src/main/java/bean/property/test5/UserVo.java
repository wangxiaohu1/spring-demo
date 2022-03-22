package bean.property.test5;

import java.util.Properties;

/**
 * @author wangxiaohu
 * @version Id: UserVo.java, v0.1 2022年03月21日 11:54:23 wangxiaohu Exp $
 */
public class UserVo {

    private Properties myproperty;

    private String name;
    private Integer age;

    public Properties getMyproperty() {
        return myproperty;
    }

    public void setMyproperty(Properties myproperty) {
        this.myproperty = myproperty;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name="+name+",age="+age;
    }
}
