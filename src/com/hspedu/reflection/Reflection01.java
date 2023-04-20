package com.hspedu.reflection;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class Reflection01 {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/re.properties"));
        String classFullPath = properties.getProperty("classfullpath").toString();
        String methodName = properties.getProperty("method").toString();
        String name = properties.getProperty("name").toString();

        Class cls = Class.forName(classFullPath);

        Object o = cls.newInstance(); // 拿到Class类对应的类的对象
        Method method = cls.getMethod(methodName);  // 拿到Class类对应的某个方法对象
        method.invoke(o); // 用方法实例 invoke 类的实例，来完成方法调用

        // field
        Field field = cls.getField("age");
        System.out.println(field.get(o));


        // constructor
        Constructor constructor = cls.getConstructor(String.class);
        System.out.println(constructor);


    }
}
