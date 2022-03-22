package webmvc.advice;

/**
 * @author wangxiaohu
 * @version Id: UserVo.java, v0.1 2022年03月21日 10:59:21 wangxiaohu Exp $
 */
public class UserVo {
    private String name;

    public UserVo() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "UserVo[name=" + this.name + "]";
    }
}
