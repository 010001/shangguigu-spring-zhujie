import com.fb01001.config.MainConfig;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
}
