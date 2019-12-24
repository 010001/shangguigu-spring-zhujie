package com.fb01001.config.condition;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.ConstructorArgumentValues;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/***
 *@Title 判断操作系统为　ｌｉｎｕｘ系统的　条件实现
 *＠author    fangbin
 *@Date 19-12-23 下午7:22
 */
public class LinuxCondition implements Condition {
    /**
     *
     * @param context 能使用的上线文环境
     * @param metadata　注释信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //是否是ｌｉｎｕｘ系统
        /**
         * １　获取ｂｅａｎ创建工厂
         */
        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();
        /**
         * ２　获取类加载器
         */
        ClassLoader classLoader = context.getClassLoader();
        /**
         * ３　获取环境信息
         */
        Environment environment = context.getEnvironment();

        System.out.println("os----" + environment.getProperty("os.name"));

        /**
         * ４　获取ｂｅａｎ定义的注册类
         */
        BeanDefinitionRegistry registry = context.getRegistry();

        /**
         * 获取容器中ｂｅａｎ注册情况
         */
        boolean personExist = registry.containsBeanDefinition("person");
        if(personExist){
            System.out.println("person exist");
        } else {
            System.out.println("person not exist");
        }
        /**
         * 给容器中注册ｂｅａｎ
         */
        //registry.registerBeanDefinition("aaa", );


        if("Linux".toLowerCase().equalsIgnoreCase(environment.getProperty("os.name").toUpperCase())){
            return true;
        }
        return false;
    }
}
