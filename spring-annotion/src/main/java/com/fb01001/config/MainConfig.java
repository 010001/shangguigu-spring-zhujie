package com.fb01001.config;

import com.fb01001.bean.Person;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/***
 *@Title 配置类
 *＠author    fangbin
 *@Date 19-12-18 下午1:42
 */
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
