#包结构说明
bean:bean相关测试<br>
context:上下问测试<br>
example:时候用Spring的案例<br>
util:工具类<br>
webmvc:spring web和mvc相关测试<br>

#example
## annotationproxy包
使用spring BeanPostProcessor和jdk动态代理技术对 spirng bean进行增强<br>
功能需求: 对使用了自定义注解@Log的bean增强, 自动打日志功能, 责任链<br>
分类：对自定义注解修饰的类实现代理<br>
实现说明:
1. LogAnnotationBeanPostProcessor实现了BeanPostProcessor, 重写postProcessAfterInitialization()方法, 在这个方法中对解析bean上是否有@Log注解并且使用jdk动态代理完成对它的代理,代理功能中打日志
2. 在UserServiceImpl上增加注解@Log, spring加载这个bean后,会调用LogAnnotationBeanPostProcessor#postProcessAfterInitialization()对bean后置增强
3. MyInvocationHandler:创建动态代理需要实现的InvocationHandler处理器接口, 在这个处理器中注入自定义的LogHandler用来做具体打日志的事情,使用Proxy.newProxyInstance方法创建一个jdk动态代理
4. LogHandler实现了我们自己定义的Ihandler接口,并且LogHandler还可以继续注入其他IHandler的实现,可以实现责任链功能

## annotationproxy2包
使用spring BeanPostProcessor和jdk动态代理技术对 spirng bean进行增强<br>
功能需求: 对使用了自定义注解@BlackListValid的bean增强, 验证黑名单<br>
分类：对自定义注解修饰的类实现代理<br>

## annotationproxy3包
使用spring BeanPostProcessor、ImportBeanDefinitionRegistrar和CGLIB动态代理技术对spring bean进行增强、并将自定义注解修饰的类托管到spring容器中
功能需求：对使用了@BizHandle的bean增强，先执注解配置的filters进行滤器，过滤成功后在执行真正的hande process方法，责任链
分类：对自定义注解修饰的类实现代理、自定义注解托管到spring容器<br>
实现说明
### 自定义注解
1. BizHandleBean：业务处理器，作用在类上的注解，Spring扫描到该注解类会进行bean创建并管理
他有一个属性是filters, 用来配置 @BizFilterBean修饰的多个过滤器
2. BizFilterBean：业务处理器的过滤器，作用在类上的注解，Spring扫描到该注解类会进行bean创建并管理
### spring bean扫描和创建规则改写
1. CustomAnnotationScanRegistrar：通过实现ImportBeanDefinitionRegistrar中的registerBeanDefinitions方法，就可以进行增加我们的自定义注解到bean容器扫描的范围中 
2. CustomAnnotationScan：作用在调用主方法的类上的注解，scanPackage用来标记扫描范围。这个注解最重要的是import了CustomAnnotationScanRegistrar 
3. CustomAnnotationPostProcessor：通过实现BeanPostProcessor的postProcessAfterInitialization方法对bean进行增强，将BizHandleBean注解的bean，以及它上的filters过滤器加构建成代理
### 接口和过滤链
1. BizFilter：过滤器接口，所有过滤器实现这个接口，它的子类都要可使用@BizFilterBean修饰
2. BizHandle：处理器接口，所有的处理器实现这个接口，它的子类都可以使用@BizHandleBean修饰
3. BizFilterChain：责任链，他持有BizHandle实例，List<BizFilter> filters，并负责filters和handler调用的先后顺序
4. HandleInvocationHandler：增强BizHandle（@BizHandleBean修饰的Bean）的代理处理器，它里面负责调用BizFilterChain.doFilter方法
### 使用
1. 定义业务过滤器：UserServiceCloseFilter、ValidBlackListFilter实现BizFilter的doFilter方法，使用注解@BizFilterBean修饰 
2. 定义业务处理器：QueryUserHandler实现BizHandle的process方法，使用注解@BizHandleBean修饰，并指定上面定义的过滤器进行处理
3. 定义一个接口：FacadeImpl接口，这里来调用QueryUserHandler
### 测试类
ATestMainApp
### 这个demo的调用流程
ATestMainApp->FacadeImpl-> QueryUserHandler（它其实是被代理的对象，会被HandleInvocationHandler代理期处理，代理期调用filterChain.doFilter方法->走filter UserServiceCloseFilter、ValidBlackListFilter->都ok后，调用QueryUserHandler）->UserService
### 相关文档
https://blog.csdn.net/qq_41733192/article/details/125908548 <br>
https://blog.csdn.net/qq_29777207/article/details/117397282 <br>
https://www.cnblogs.com/levcon/p/16485336.html

