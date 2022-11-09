package example.annotationproxy3.biz.handle;

import example.annotationproxy3.annotation.BizHandleBean;
import example.annotationproxy3.biz.filter.UserServiceCloseFilter;
import example.annotationproxy3.biz.filter.ValidBlackListFilter;
import example.annotationproxy3.biz.service.UserServiceImpl;
import example.annotationproxy3.filter.BizHandle;
import example.annotationproxy3.filter.BizRequest;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author wangxh
 * @date 2022/11/7 3:07 PM
 */
//@Component
@BizHandleBean(filters = {UserServiceCloseFilter.class, ValidBlackListFilter.class})
public class QueryUserHandler implements BizHandle {
    @Autowired
    private UserServiceImpl userService;
    @Override
    public void process(BizRequest request) {
        System.out.println("QueryUserHandler.process");
        userService.getUser(request.getUserName());
    }
}
