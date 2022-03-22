package webmvc.a_helloword;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author wangxiaohu
 * @version Id: HelloController.java, v0.1 2022年03月21日 10:55:24 wangxiaohu Exp $
 */
@Controller
@RequestMapping({"hello"})
public class HelloController {
    public HelloController() {
    }

    @RequestMapping({"sayHello"})
    @ResponseBody
    public List<String> sayHello(String name) {
        System.out.println("/hello/sayHello 入参name=" + name);
        List<String> list = new ArrayList();
        list.add("hello");
        return list;
    }

    @RequestMapping({"returnView"})
    public String returnView(String name) {
        System.out.println("/hello/returnView入参name=" + name);
        return "hello";
    }
}

