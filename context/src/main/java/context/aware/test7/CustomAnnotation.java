package context.aware.test7;

import java.lang.annotation.*;

/**
 * @author wangxh
 * @date 2022/11/7 3:40 PM
 */
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Target({ElementType.TYPE})
public @interface CustomAnnotation {

}
