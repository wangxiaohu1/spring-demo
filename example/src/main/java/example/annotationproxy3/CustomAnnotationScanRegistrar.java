package example.annotationproxy3;
import example.annotationproxy3.annotation.BizFilterBean;
import example.annotationproxy3.annotation.BizHandleBean;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.StandardAnnotationMetadata;
import org.springframework.core.type.filter.AnnotationTypeFilter;

/**
 * @author wangxh
 * @date 2022/11/8 11:26 AM
 */
public class CustomAnnotationScanRegistrar implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
    private ResourceLoader resourceLoader;
    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        // 获取自定义扫描注解的信息
        AnnotationAttributes annotationAttributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(CustomAnnotationScan.class.getName()));
        String[] scanPackages = new String[0];
        if (annotationAttributes != null) {
            scanPackages = annotationAttributes.getStringArray("scanPackage");
        }
        if (scanPackages.length == 0) {
            // 未设置就默认为自定义注解作用类所在包
            scanPackages = new String[]{((StandardAnnotationMetadata) importingClassMetadata).getIntrospectedClass().getPackage().getName()};
        }
        // 增加自定义注解的扫描，同时保留spring预设bean注解的扫描（@Component等）
        ClassPathBeanDefinitionScanner serviceScanner = new ClassPathBeanDefinitionScanner(registry,true);
        serviceScanner.addIncludeFilter(new AnnotationTypeFilter(BizHandleBean.class));
        serviceScanner.addIncludeFilter(new AnnotationTypeFilter(BizFilterBean.class));
        //serviceScanner.addIncludeFilter(new AnnotationTypeFilter(ValidCinemaChannelBean.class));
        if (resourceLoader != null) {
            serviceScanner.setResourceLoader(resourceLoader);
        }

        // 开始扫描
        int beanCount = serviceScanner.scan(scanPackages);
        System.out.println("bean count:" + beanCount);
    }
}
