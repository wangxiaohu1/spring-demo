package example.proxy.service.biz;

import example.proxy.annotation.Log;
import org.springframework.stereotype.Service;

@Log(interfaceName = UserService.class)
@Service
public class UserServiceImpl implements UserService{
    @Override
    public String findNames() {
        System.out.println(" UserServiceImpl#findNames");
        return "123";
    }
}
