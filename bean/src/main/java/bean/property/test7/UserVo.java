package bean.property.test7;

import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

/**
 * @author wangxiaohu
 * @version Id: AppleVo.java, v0.1 2022年03月21日 11:54:23 wangxiaohu Exp $
 */
@Component
public class UserVo {

    @Resource(name = "myproperty")
    private Properties myproperty;

    public Properties getMyproperty() {
        return myproperty;
    }

}
