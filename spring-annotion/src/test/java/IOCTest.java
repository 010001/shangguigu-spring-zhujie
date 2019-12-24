import com.fb01001.bean.Person;
import com.fb01001.config.MainConfig;
import com.fb01001.config.MainConfig02;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import java.util.Map;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 19-12-18 下午5:59
 */
public class IOCTest {

    @Test
    public void test01(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }

    }

    @Test
    public void test02(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);
        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }

        // ICO容器中默认是单实例的
        Object person01 = annotationConfigApplicationContext.getBean("zhangsan");
        Object person02 = annotationConfigApplicationContext.getBean("zhangsan");
        System.out.println(person01 == person02);

    }

    @Test
    public void test03(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);
        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }

        // ICO容器中默认是单实例的
        Object person01 = annotationConfigApplicationContext.getBean("zhangsan");
        Object person02 = annotationConfigApplicationContext.getBean("zhangsan");
        System.out.println(person01 == person02);

        System.out.println("----容器启动完成－－－－");
        //　设置多实例
        Object lisi01 = annotationConfigApplicationContext.getBean("lisi");
        Object lisi02 = annotationConfigApplicationContext.getBean("lisi");
        Object lisi03 = annotationConfigApplicationContext.getBean("lisi");
        System.out.println(lisi01 == lisi02);

    }

    @Test
    public void test04(){
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);
        /*String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        for(String name : names){
            System.out.println(name);
        }

        // ICO容器中默认是单实例的
        Object person01 = annotationConfigApplicationContext.getBean("zhangsan");
        Object person02 = annotationConfigApplicationContext.getBean("zhangsan");
        System.out.println(person01 == person02);*/

        System.out.println("----容器启动完成－－－－");
        //　设置多实例
        /*Object lisi01 = annotationConfigApplicationContext.getBean("lisi");
        Object lisi02 = annotationConfigApplicationContext.getBean("lisi");
        Object lisi03 = annotationConfigApplicationContext.getBean("lisi");
        System.out.println(lisi01 == lisi02);*/

        Object wangwu01 = annotationConfigApplicationContext.getBean("wangwu");
        Object wangwu02 = annotationConfigApplicationContext.getBean("wangwu");
        System.out.println(wangwu01 == wangwu02);

    }


    @Test
    public void test05() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);

        /*Object p1 = annotationConfigApplicationContext.getBean("bill");
        Object p2 = annotationConfigApplicationContext.getBean("linus");
        System.out.println(p1.toString());*/
        /*String[] names = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for (String name: names
             ) {
            System.out.println(name);
        }*/

        Map<String, Person> personsMap = annotationConfigApplicationContext.getBeansOfType(Person.class);
        for (String name : personsMap.keySet()){
            System.out.println(name);
        }

        /*ConfigurableEnvironment environment = annotationConfigApplicationContext.getEnvironment();
        *//**
         * 动态获取当前系统的操作系统名称
         * Linux
         *//*
        System.out.println(environment.getProperty("os.name"));*/
    }

    @Test
    public void testImport() {
        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig02.class);
        this.printBeans(annotationConfigApplicationContext);
    }
    private void printBeans(AnnotationConfigApplicationContext annotationConfigApplicationContext ){
        String[] names = annotationConfigApplicationContext.getBeanDefinitionNames();
        for (String name: names
             ) {
            System.out.println(name);
        }
    }
}