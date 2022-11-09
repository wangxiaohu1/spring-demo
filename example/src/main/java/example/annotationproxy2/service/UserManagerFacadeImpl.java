package example.annotationproxy2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangxh
 * @date 2022/11/8 4:56 PM
 */
@Service
public class UserManagerFacadeImpl {
    @Autowired
    private UserService userService;
    public UserInfo queryUserByName(String userName){
        System.out.println("UserManagerFacadeImpl.queryUserByName");
        UserInfo userInfo = userService.queryUserByName(userName);
        return userInfo;
    }
}
