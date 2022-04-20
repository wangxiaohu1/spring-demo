package context.aware.test6;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ResourceLoader;

/**
 * ResourceLoaderAware:获得资源加载器，可以获得外部资源文件的内容
 */
public class ResourceLoaderAwareTest implements ResourceLoaderAware {
    private static ResourceLoader resourceLoader;
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:context/aware/test6/spring.xml");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader=resourceLoader;
        System.out.println("进入ResourceLoaderAware#setResourceLoader");
    }
}
