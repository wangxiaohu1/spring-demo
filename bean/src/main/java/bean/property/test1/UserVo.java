package bean.property.test1;

/**
 * @author wangxiaohu
 * @version Id: UserVo.java, v0.1 2022年03月21日 11:43:11 wangxiaohu Exp $
 */
public class UserVo {
    private String name;
    private Integer age;
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
