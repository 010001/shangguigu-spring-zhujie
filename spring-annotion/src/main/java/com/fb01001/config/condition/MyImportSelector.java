package com.fb01001.config.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/***
 *@Title 自定义逻辑，返回需要导入的组件
 *＠author    fangbin
 *@Date 19-12-24 上午11:14
 */
public class MyImportSelector implements ImportSelector {
    /**
     * 返回值就是要导入到容器中的组件的全类名
     * AnnotationMetadata 当前标记@Import注解的类的所有的注解信息
     * @param importingClassMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

       /* String[] memberClassNames = importingClassMetadata.getMemberClassNames();
        for (String name: memberClassNames
             ) {
            System.out.println(name);
        }*/
       //方法不能返回 null 会引起空指针问题

        return new String[]{"com.fb01001.bean.Blue","com.fb01001.bean.Yellow"};
    }
}
