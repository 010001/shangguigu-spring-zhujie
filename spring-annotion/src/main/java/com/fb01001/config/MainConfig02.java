package com.fb01001.config;

import com.fb01001.bean.Color;
import com.fb01001.bean.Person;
import com.fb01001.bean.Red;
import com.fb01001.config.condition.LinuxCondition;
import com.fb01001.config.condition.MyImportSelector;
import com.fb01001.config.condition.WinCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 19-12-20 下午5:48
 */
//　类中组件统一设置
// 满足LinuxCondition 条件，当前配置文件下加的所有类注册才能生效
//@Conditional({LinuxCondition.class})

/**
 * 自动导入Color
 * bean　id默认为　Color的全类名
 */
//@Import({Color.class, Red.class,MyImportSelector.class})
@Import(MyImportSelector.class)
public class MainConfig02 {


    /**
     * 给容器中注册组件：
     * １ 包扫描　＋　组件注解　（＠Controller @Service @Repository @Component） 自己写的类
     * 2 @Bean 导入的第三方包中的组件
     * 3 ＠Ｉｍｐｏｒｔ　快速给容器中导入组件，容器自动注册组件，组件ｉｄ为类的全类名
     * 4 @ImportSelector 返回需要导入的组件的全类名数组
     */

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

    /**
     * Conditional 传Condition
     * 按照一定条件进行判断，满足条件给容器中注册ｂｅａｎ
     *  如果是ｗｉｎ系统则注入ｂｉｌｌ
     *  如果是ｌｉｎｕｘ系统则注入ｌｉｎｕｓ
     */
    @Conditional({WinCondition.class})
    @Bean("bill")
    public Person Person0４(){
        System.out.println("给容器中增加实例。。。。。bill------");
        return new Person("bill",56);
    }
    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person Person0５(){
        System.out.println("给容器中增加实例。。。。。linus------");
        return new Person("linus",70);
    }

}
