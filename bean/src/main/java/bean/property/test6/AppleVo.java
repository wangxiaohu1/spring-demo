package bean.property.test6;

import java.util.Properties;

/**
 * @author wangxiaohu
 * @version Id: AppleVo.java, v0.1 2022年03月21日 14:32:43 wangxiaohu Exp $
 */
public class AppleVo {
    private String name;
    private Integer type;
    private String year;
    private Properties myproperty;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Properties getMyproperty() {
        return myproperty;
    }

    public void setMyproperty(Properties myproperty) {
        this.myproperty = myproperty;
    }

    @Override
    public String toString() {
        return "name="+name+",type="+type+",year="+year;
    }
}
