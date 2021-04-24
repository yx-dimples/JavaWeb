package com.tedu;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * 使用反射 创建pojo对象 对属性赋值
 */
public class PojoTest {

    @Test
    public void createObject() throws Exception {
        Class<?> c = Class.forName("com.news.pojo.NewsTopic");
        //使用反射创建对象
        Object o = c.newInstance();
        System.out.println(o);
        //通过反射获取遍历
        Field[] declaredFields = c.getDeclaredFields();
        System.out.println(declaredFields);
        //遍历属性 ------- res 遍历
//        for(Field f:declaredFields) {
//            String name = f.getName();
//            System.out.println(name);
            // 调用SetXX方法
            // 直接给属性赋值
        declaredFields[0].setAccessible(true);
            // 赋值
        declaredFields[0].set(o,11);

        declaredFields[1].setAccessible(true);
        declaredFields[1].set(o,"hello");
     //   }
        System.out.println(o);

    }
}
