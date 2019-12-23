package com.fb01001.config;

import com.fb01001.bean.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

/***
 *@Title 配置类
 *＠author    fangbin
 *@Date 19-12-18 下午1:42
 */

/*@ComponentScans({
        @ComponentScan(value = "com.fb01001",includeFilters = {
                @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class})
        },useDefaultFilters = false)
})*/
//　排除指定类型的组件
/*@ComponentScan(value = "com.fb01001",excludeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class, Service.class,org.springframework.stereotype.Repository.class})
})*/
// 只包含指定的组件
/*@ComponentScan(value = "com.fb01001",includeFilters = {
        @ComponentScan.Filter(type= FilterType.ANNOTATION,classes = {Controller.class})
},useDefaultFilters = false)*/

/**
 * FilterType.ANNOTATION  按照注解
 * FilterType.ASSIGNABLE_TYPE  按照给定的类型
 * FilterType.ASPECTJ ASPECTJ表达式
 * FilterType.REGEX　　正则表达式
 * FilterType.CUSTOM　自定义规则
 *
 */
/*@ComponentScans({
        @ComponentScan(value = "com.fb01001",includeFilters = {
                @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {MyTypeFilter.class}
                )
        },
                useDefaultFilters = false)
})*/
@Configuration
public class MainConfig {


    //　给容器中注册了一个bean，类型为返回值类型，id 默认为方法名作为id
    @Bean("person")
    public Person person01(){
        Person person = new Person();
        person.setAge(18);
        person.setId("1111");
        person.setName("张三");
        return person;
    }
}
