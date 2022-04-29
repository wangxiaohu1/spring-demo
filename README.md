#包结构说明
bean:bean相关测试<br>
context:上下问测试<br>
example:时候用Spring的案例<br>
util:工具类<br>
webmvc:spring web和mvc相关测试<br>

#example
proxy包:使用spring BeanPostProcessor和jdk动态代理技术对 spirng bean进行增强<br>
功能需求: 对使用了自定义注解@Log的bean增强, 自动打日志功能, 责任链<br>
实现说明:
1. LogAnnotationBeanPostProcessor实现了BeanPostProcessor, 重写postProcessAfterInitialization()方法, 在这个方法中对解析bean上是否有@Log注解并且使用jdk动态代理完成对它的代理,代理功能中打日志
2. 在UserServiceImpl上增加注解@Log, spring加载这个bean后,会调用LogAnnotationBeanPostProcessor#postProcessAfterInitialization()对bean后置增强
3. MyInvocationHandler:创建动态代理需要实现的InvocationHandler处理器接口, 在这个处理器中注入自定义的LogHandler用来做具体打日志的事情,使用Proxy.newProxyInstance方法创建一个jdk动态代理
4. LogHandler实现了我们自己定义的Ihandler接口,并且LogHandler还可以继续注入其他IHandler的实现,可以实现责任链功能
