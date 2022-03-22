package bean.property.test6;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author wangxiaohu
 * @version Id: AppleVo.java, v0.1 2022年03月21日 14:32:43 wangxiaohu Exp $
 */
@Component
public class AppleVo2 {
    @Value("#{myproperty['apple.name']}")
    private String name;
    @Value("#{myproperty['apple.type']}")
    private Integer type;
    @Value("#{myproperty['apple.year']}")
    private String year;

    @Resource(name="myproperty")
    private Properties myproperty1;
    @Value("#{myproperty}")
    private Properties myproperty2;


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

    public Properties getMyproperty1() {
        return myproperty1;
    }

    public Properties getMyproperty2() {
        return myproperty2;
    }

    @Override
    public String toString() {
        return "name="+name+",type="+type+",year="+year;
    }
}
