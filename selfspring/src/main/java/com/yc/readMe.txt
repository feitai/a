IOC:控制反转  inverse of controll
   @Bean

   @Component  @Service  @Repository   @Controller
DI:依赖注入   dependency injection
   @Value
   @Autowired  @Qualifier
   @Resource

   @Inject    @Named
   @Primary

容器类注解
@Configuration
@ComponentScan

@PropertySource

@Import
@ImportSelect

生命周期:
	@PostConstruct
	@PreDestroy

==================================
ApplicationContext 接口  getBean()
	基于xml 类路径下扫描
	基于注解扫描
 	基于系统路径

====================================
注解的声明:
1. @interface 注解名{
           String value() default "";
           String[] aa() default {};
           int b() default 0;
}
2. 元注解:
  @Target(   method, field, constructor, type 。。。）
  @Retention(    Source, class,  runtime  )
3. 利用反射机制去读取.
     Class类的实例.
                 isAnnotationPresent();
    Annotation anno=                 getAnnotation()
   anno.value()/   .....()
===================================