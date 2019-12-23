package com.fb01001.config;

import org.springframework.core.io.Resource;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/***
 *@Title ${TODO}
 *＠author    fangbin
 *@Date 19-12-23 上午10:55
 */
public class MyTypeFilter implements TypeFilter {
    /**
     *
     * @param metadataReader　读取到的当前正在扫描的类的信息
     * @param metadataReaderFactory　可以获取到其他任何类信息
     * @return
     * @throws IOException
     */
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        /**
         * 获取当前类注解的信息
         */
        AnnotationMetadata annotationMetadata = metadataReader.getAnnotationMetadata();
        /**
         * 获取当前正在扫描的类的类信息
         */
        ClassMetadata classMetadata = metadataReader.getClassMetadata();
        System.out.println("－－> " + classMetadata.getClassName());
        /**
         * 获取当前正在扫描的类的类资源信息 (类路径之类的信息)
         */
        Resource resource = metadataReader.getResource();

        /**
         * 定制过滤规则
         * 只要包含Ｓｅｒｖｉｃｅ　的都扫描到容器中
         */
        if(classMetadata.getClassName().contains("Service")){
            return true;
        }



        return false;
    }
}
