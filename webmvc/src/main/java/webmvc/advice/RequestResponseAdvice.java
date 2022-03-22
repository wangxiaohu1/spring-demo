package webmvc.advice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author wangxiaohu
 * @version Id: RequestResponseAdvice.java, v0.1 2022年03月21日 10:58:29 wangxiaohu Exp $
 */
@Component
@ControllerAdvice(
    basePackages = {"demo.advice.controller"}
)
public class RequestResponseAdvice implements ResponseBodyAdvice<Object> {
    public RequestResponseAdvice() {
    }

    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        System.out.println("进入：RequestResponseAdvice.supports");
        return true;
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result) {
            return body;
        } else {
            Result result = new Result("ok", "成功", body);

            try {
                System.out.println("进入：RequestResponseAdvice.beforeBodyWrite,result=" + result);
            } catch (Exception var9) {
                var9.printStackTrace();
            }

            return result;
        }
    }
}
