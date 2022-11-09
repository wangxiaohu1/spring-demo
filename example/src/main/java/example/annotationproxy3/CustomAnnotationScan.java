package example.annotationproxy3;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author wangxh
 * @date 2022/11/8 11:24 AM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(CustomAnnotationScanRegistrar.class)
public @interface CustomAnnotationScan {
   String[] scanPackage();
}
