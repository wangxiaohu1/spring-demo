package example.annotationproxy2.annotation;

import java.lang.annotation.*;

/**
 * @author wangxh
 * @date 2022/11/8 4:25 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.PARAMETER, ElementType.FIELD})
public @interface ValidBlackListParam {

}
