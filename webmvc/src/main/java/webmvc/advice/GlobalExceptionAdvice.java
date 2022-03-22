package webmvc.advice;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

/**
 * @author wangxiaohu
 * @version Id: GlobalExceptionAdvice.java, v0.1 2022年03月21日 10:57:02 wangxiaohu Exp $
 */
@Component
@ControllerAdvice(
    basePackages = {"demo.advice.controller"}
)
public class GlobalExceptionAdvice {
    public GlobalExceptionAdvice() {
    }

    @ExceptionHandler({IllegalArgumentException.class})
    @ResponseBody
    public Object handleIllegalArgumentException(IllegalArgumentException ex, WebRequest req) {
        Result result = new Result("error", "失败", (Object)null);
        System.out.println("进入：GlobalExceptionAdvice.handleIllegalArgumentException");
        return result;
    }

    @ExceptionHandler({Throwable.class})
    @ResponseBody
    public Object handleThrowable(Throwable ex, WebRequest req) {
        Result result = new Result("error", "失败", (Object)null);
        System.out.println("进入：GlobalExceptionAdvice.handleThrowable");
        ex.printStackTrace();
        return result;
    }
}
