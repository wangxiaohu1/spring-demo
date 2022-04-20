package context.aware.test1;

import org.springframework.context.ApplicationContext;

public class ApplicationContextUtil {
    private static ApplicationContext ctx;
    public static Object getBean(String name){
        return ctx.getBean(name);
    }
    protected static void setApplicationContext(ApplicationContext applicationContext){
        ctx=applicationContext;
    }
}
