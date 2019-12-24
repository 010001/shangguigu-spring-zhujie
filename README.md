# 尚硅谷spring注解开发练习

- 向容器中注入bean

  - ```java
    @Bean
    ```

- 容器　

- 配置类

  - ```java
    @Configuration
    ```

- 增加过滤器　

  - 添加指定类型组件

    - ```java
      @ComponentScans({
          @ComponentScan(value = "com.fb01001",
          includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})},
          useDefaultFilters = false)})
      
      @ComponentScan(
          value = "com.fb01001",
          includeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class})},
          useDefaultFilters = false)
      ```

  - 排除指定类型组件

    - ```java
      @ComponentScan(value = "com.fb01001",
      excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class, Service.class,org.springframework.stereotype.Repository.class})})
      ```

- 容器实例

  - 单实例

    - ```java
      @Scope(value = "singleton")
      ```

  - 多实例

    - ```java
      @Scope(value = "prototype")
      ```

  - 懒加载

    - ```java
      @Lazy
      ```

- 给容器中注册组件：
  - １ 包扫描＋组件注解　（＠Controller @Service @Repository @Component） 自己写的类
  - 2 @Bean 导入的第三方包中的组件
  - 3 ＠Import
    - 3.1 @Import快速给容器中导入组件，容器自动注册组件，组件ｉｄ为类的全类名
    - 3.2 @ImportSelector 返回需要导入的组件的全类名数组
    - 3.3 @ImportBeanDefinitionRegistrar 手动注册bean到容器中