import com.fb01001.bean.Person;
import com.fb01001.config.MainConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 19-12-18 下午1:39
 */
public class MainTest {
    public static void main(String[] args) {
        /*ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        Person person = (Person) applicationContext.getBean("person");
        System.out.println(person);*/

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        Person person = annotationConfigApplicationContext.getBean(Person.class);
        System.out.println(person);

        String[] beanNames = annotationConfigApplicationContext.getBeanNamesForType(Person.class);
        for(String beanName : beanNames ){
            System.out.println(beanName);
        }

    }
}
