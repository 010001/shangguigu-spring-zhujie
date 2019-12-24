package com.fb01001.config.condition;

import com.fb01001.bean.RainBow;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 19-12-24 下午1:35
 */
public class MyImportBeanDefinitionRegistrar implements ImportBeanDefinitionRegistrar {


    /**
     *
     * @param importingClassMetadata 当前类的注解信息
     * @param registry　ｂｅａｎ　的注册类
     *                使用　registerBeanDefinition　方法手工注册类
     */
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {

        //boolean red = registry.containsBeanDefinition("com.fb01001.bean.Red");
        boolean blue = registry.containsBeanDefinition("com.fb01001.bean.Blue");
        boolean yellow = registry.containsBeanDefinition("com.fb01001.bean.Yellow");
        if(blue && yellow){
            //　注册一个ｂｅａｎ　指定ｂｅａｎ的定义信息
            BeanDefinition beanDefinition = new RootBeanDefinition(RainBow.class);
            // 注册一个ｂｅａｎ　指定ｂｅａｎ名称
            registry.registerBeanDefinition("rainBow",beanDefinition);
        }

    }
}
