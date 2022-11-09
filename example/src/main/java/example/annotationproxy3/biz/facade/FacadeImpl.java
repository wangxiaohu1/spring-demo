package example.annotationproxy3.biz.facade;

import example.annotationproxy3.filter.BizHandle;
import example.annotationproxy3.filter.BizRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author wangxh
 * @date 2022/11/8 3:19 PM
 */
@Service
public class FacadeImpl {
    @Autowired
    private BizHandle handle;
    public void test(BizRequest request){
        handle.process(request);
    }
}
