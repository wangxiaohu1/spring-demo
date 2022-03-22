package webmvc.advice;

/**
 * @author wangxiaohu
 * @version Id: Result.java, v0.1 2022年03月21日 10:58:54 wangxiaohu Exp $
 */
public class Result {
    private String errorCode;
    private String errorMsg;
    private Object data;

    public Result(String errorCode, String errorMsg, Object data) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public String getErrorCode() {
        return this.errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public Object getData() {
        return this.data;
    }

    public String toString() {
        return "Result[errorCode=" + this.errorCode + ",errorMsg=" + this.errorMsg + ",data=" + this.data + "]";
    }
}
