package example.annotationproxy.service.api;

import example.annotationproxy.service.biz.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserQueryAPIImpl implements UserQueryAPI{
    @Autowired
    private UserService userService;

    public String queryNameById(Long id){
        System.out.println("UserQueryAPIImpl#queryNameById内开始,开始调用userService#findNames");
        String name = userService.findNames();
        System.out.println("UserQueryAPIImpl#queryNameById内结束,完成调用userService#findNames");
        return name;
    }

}
