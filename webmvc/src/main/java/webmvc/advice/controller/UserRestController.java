package webmvc.advice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import webmvc.advice.UserVo;

/**
 * @author wangxiaohu
 * @version Id: UserRestController.java, v0.1 2022年03月21日 10:56:23 wangxiaohu Exp $
 */
@RestController
@RequestMapping({"advice/controller/user"})
public class UserRestController {
    public UserRestController() {
    }

    @RequestMapping({"list"})
    public List<UserVo> list() {
        System.out.println("进入 advice/controller/user/list");
        List<UserVo> list = new ArrayList();
        UserVo userVo = new UserVo();
        userVo.setName("java");
        list.add(userVo);
        return list;
    }
}