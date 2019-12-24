package com.fb01001.bean.colour;

import com.fb01001.bean.Color;
import org.springframework.beans.factory.FactoryBean;

/***
 *创建一个Spring定义的工厂类
 *＠author    fangbin
 *@Date 19-12-24 下午3:14
 */
public class ColourFactoryBean implements FactoryBean<Color> {
    /**
     * 返回一个Ｃｏｌｏｕｒ对象
     * @return
     * @throws Exception
     */
    @Override
    public Color getObject() throws Exception {
        System.out.println("------isSingleton　-> false 调用　getObject　创建对象--------");
        return new Color();
    }

    @Override
    public Class<?> getObjectType() {
        return Color.class;
    }

    /**
     * 单例还是　不是单例
     * 返回ｔｒｕｅ　则为单例模式　在容器中保存一个
     * 返回ｆａｌｓｅ则不是单例模式　多实例模式，每次调用都调用getObject　方法创建新的实例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return false;
    }
}
