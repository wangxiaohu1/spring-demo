package example.annotationproxy2.handler;

import example.annotationproxy2.annotation.ValidBlackList;
import example.annotationproxy2.annotation.ValidBlackListParam;
import org.springframework.core.annotation.AnnotationUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangxh
 * @date 2022/11/8 4:47 PM
 */
public class MyInvocationHandler implements InvocationHandler {
    private static List<String> blackList = new ArrayList<>();
    static {
        blackList.add("123");
    }
    private Object bean;
    public MyInvocationHandler(Object bean){
        this.bean = bean;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyInvocationHandler.invoke");
        Method targetMethod = bean.getClass().getMethod(method.getName(),method.getParameterTypes());
        Annotation annotation = AnnotationUtils.getAnnotation(targetMethod, ValidBlackList.class);
        if(annotation!=null){
            Parameter[] parameters = targetMethod.getParameters();
            Object value = null;
            for(int index=0;index<parameters.length;index++){
                annotation = parameters[index].getAnnotation(ValidBlackListParam.class);
                if(annotation!=null){
                    value = args[index];
                    break;
                }
            }
            //验证
            boolean success = true;
            if(value!=null && value.toString().trim().length()>0){
                success = !blackList.contains(value.toString());
            }
            if(success){
                return method.invoke(bean,args);
            }else{
                System.out.println(" 验证不通过返回null");

                return null;
            }
        }else{
            return method.invoke(bean,args);
        }


    }
}
