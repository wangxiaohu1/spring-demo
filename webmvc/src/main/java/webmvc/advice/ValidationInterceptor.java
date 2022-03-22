package webmvc.advice;

import java.util.Iterator;
import java.util.List;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.FieldError;

/**
 * @author wangxiaohu
 * @version Id: ValidationInterceptor.java, v0.1 2022年03月21日 10:59:43 wangxiaohu Exp $
 */
@Component
public class ValidationInterceptor implements MethodInterceptor {
    public ValidationInterceptor() {
    }

    public Object invoke(MethodInvocation invocation) throws Throwable {
        if (invocation.getArguments() != null && invocation.getArguments().length != 0) {
            Object[] var2 = invocation.getArguments();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                Object o = var2[var4];
                if (o instanceof BeanPropertyBindingResult) {
                    BeanPropertyBindingResult bindingResult = (BeanPropertyBindingResult)o;
                    List<FieldError> errors = bindingResult.getFieldErrors();
                    FieldError var9;
                    if (errors != null && !errors.isEmpty()) {
                        for(Iterator var8 = errors.iterator(); var8.hasNext(); var9 = (FieldError)var8.next()) {
                            ;
                        }
                    }
                }
            }
        }

        Object obj = null;

        Object var16;
        try {
            System.out.println("进入：ValidationInterceptor");
            obj = invocation.proceed();
            var16 = obj;
        } catch (Throwable var13) {
            throw var13;
        } finally {
            System.out.println("退出：ValidationInterceptor,obj=" + obj);
        }

        return var16;
    }
}
