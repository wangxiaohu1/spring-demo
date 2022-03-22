package webmvc.mvcmocks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxiaohu
 * @version Id: XController01_MockMvc.java, v0.1 2022年03月21日 11:01:17 wangxiaohu Exp $
 */
@RequestMapping({"test01"})
@RestController
public class XController01_MockMvc {
    public XController01_MockMvc() {
    }

    @RequestMapping({"list01"})
    public List<String> list01(String type) {
        List<String> list = new ArrayList();
        list.add("java");
        return list;
    }
}
