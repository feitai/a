1. maven中的依赖继承, 父子模块的关系.
2. 日志的配置
3. spring分析. spring原版注解:
     (1)容器配置相关注解
         @Configuration:  加了 Component,说明此配置类也要被spring托管.
         @ComponentScan

     (2)IOC相关注解
         @Component:  基础IOC注解,以下IOC注解都是 此注解的具体实现.
         @Repository
         @Service
         @Controller

         @Bean:  在配置类中加在方法上,用于托管第三方类

     (3)DI注解:
         @Autowired
         @Qualifier
         @Value

     (4)生命周期管理注解
          @Lazy
          @Scope


     并请根据你的理解，做自定义的实现( 要求名字稍改一下，在前面加一个Yc以示区分).

         重点:
          1. 这些注解是加在什么位置(类，方法，属性。。。。)?, 怎么定义?
          2. 这些注解是否有参数？参数是什么，有没有默认值？如何实现?
          3. 这些注解的retentionPolicy保持策略( 即什么时候有效,取值有  source->compile->runtime )






                                        元注解
          1.@Target ：用于描述注解的使用范围，也就是说使用了@Target去定义一个注解，那么可以决定定义好的注解能用在什么地方

          2.@Retention：用于描述注解的生命周期，也就是说这个注解在什么范围内有效，注解的生命周期和三个阶段有关：源代码阶段、
          CLASS文件中有效、运行时有效，故其取值也就三个值，分别代表着三个阶段

          3.@Documented：表示该注解是否可以生成到 API文档中。在该注解使用后，如果导出API文档，
          会将该注解相关的信息可以被例如javadoc此类的工具文档化。 注意：Documented是一个标记注解，没有成员。

          4.@Inherited：使用@Inherited定义的注解具备继承性