package com.fb01001.config;

import com.fb01001.bean.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 19-12-20 下午5:48
 */
public class MainConfig02 {

    public static void main(String[] args) {

    }


    // 默认都是单实例的
    @Bean("zhangsan")
    public Person Person01(){
        System.out.println("给容器中增加实例。。。。。zhangsan------");
        return new Person("zhangsan",23);
    }

    @Scope(value = "prototype")
    /**
     * 使用Scope调整组件的作用域
     * ConfigurableBeanFactory#SCOPE_PROTOTYPE 多实例的　　　　　　　ico容器启动时不调用创建方法，在获取ｂｅａｎ的时候，调用创建实例的方法并返回实例，每次调用都新建实例
     * ConfigurableBeanFactory#SCOPE_SINGLETON　单实例的　（默认值） ico容器启动时会调用方法创建对象放到容器实例中，以后每次获取都是从容器中获取
     * org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request 同一个请求创建一个实例
     * org.springframework.web.context.WebApplicationContext#SCOPE_SESSION  session　同一个ｓｅｓｓｉｏｎ创建一个实例
     */
    @Bean("lisi")
    public Person Person02(){
        System.out.println("给容器中增加实例。。。。。lisi------");
        return new Person("lisi",34);
    }

    /**
     * 针对　单实例bean,第一次调用的时候创爱你对象
     *      懒加载
     *        容器启动的时候不创建对象，第一次使用对象的时候初始化对象
     * @return
     */
    //@Scope(value = "prototype")
    @Scope(value = "singleton")
    @Lazy
    @Bean("wangwu")
    public Person Person03(){
        System.out.println("给容器中增加实例。。。。。wangwu------");
        return new Person("wangwu",56);
    }

}