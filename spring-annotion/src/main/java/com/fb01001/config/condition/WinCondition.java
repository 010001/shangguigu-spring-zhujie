package com.fb01001.config.condition;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/***
 *@Title 判断操作系统为　Ｗｉｎ系统的　条件实现
 *＠author    fangbin
 *@Date 19-12-23 下午7:23
 */
public class WinCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Environment environment = context.getEnvironment();

        System.out.println("os----" + environment.getProperty("os.name"));


        if(environment.getProperty("os.name").toUpperCase().contains("WIN")){
            return true;
        }

        return false;
    }
}
