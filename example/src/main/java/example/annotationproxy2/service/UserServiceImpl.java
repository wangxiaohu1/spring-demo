package example.annotationproxy2.service;

import example.annotationproxy2.annotation.ValidBlackList;
import example.annotationproxy2.annotation.ValidBlackListParam;
import org.springframework.stereotype.Service;

/**
 * @author wangxh
 * @date 2022/11/8 4:22 PM
 */
@Service
@ValidBlackList
public class UserServiceImpl implements UserService{
    @Override
    @ValidBlackList
    public UserInfo queryUserByName(@ValidBlackListParam String userName) {
        System.out.println("  UserServiceImpl.saveUser");
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        return userInfo;
    }
}
