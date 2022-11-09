package example.annotationproxy3.biz.service;

import org.springframework.stereotype.Service;

/**
 * @author wangxh
 * @date 2022/11/9 11:15 AM
 */
@Service
public class UserServiceImpl {
    public UserInfo getUser(String userName){
        System.out.println("UserServiceImpl.getUser");
        UserInfo user = new UserInfo();
        user.setUserName(userName);
        return user;
    }
}
