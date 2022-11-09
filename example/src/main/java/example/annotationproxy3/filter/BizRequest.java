package example.annotationproxy3.filter;

/**
 * @author wangxh
 * @date 2022/11/9 10:36 AM
 */
public class BizRequest {
    private String userName;
    public BizRequest(String userName){
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
