package com.hspedu.reflection.question;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionQuestion {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
//        Cat cat = new Cat();
//        cat.hi();

        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\re.properties"));
        String classfullpath = properties.get("classfullpath").toString();
        String methodName = properties.get("method").toString();
        System.out.println("classfullpath=" + classfullpath + "   methodName=" + methodName);

        // 1. 加载类，返回Class类型的对象cls
        Class cls = Class.forName(classfullpath);

        // 2. 通过cls得到你加载的类 com.hspedu.Cat 的对象实例
        Object o = cls.newInstance();
        System.out.println(o.getClass());

        // 3. 通过cls 得到你加载的类 com.hspedu.Cat 的 methodName "hi" 的方法对象
        // 即：在反射中，可以把方法视作对象（万物皆对象）
        Method method1  = cls.getMethod(methodName);

        System.out.println("========================");

        // 4. 通过method1 调用方法，即通过方法对象来实现调用方法
        method1.invoke(o);  //传统方法： 对象.方法()， 反射机制： 方法.invoke(对象)


    }
}
