package com.hspedu.classload;

import java.lang.reflect.Method;
import java.security.DigestException;
import java.util.Scanner;

public class _ClassLoad {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please input key: ");
        String key = scanner.next();
        switch (key) {
            case "1":
//                Dog dog = new Dog(); //静态加载，依赖性强，编译器的时候就加载，直接报错
//                dog.cry();
                break;
            case "2":
                // 用的是反射 -> 动态加载
                Class cls = Class.forName("com.hspedu.reflection.Person");  // 动态加载（延时加载），当我们运行的时候才加载类，这里是在runtime的时候才会加载person类
                Object o = cls.newInstance();
                Method method = cls.getMethod("sayHi");
                method.invoke(o);
                System.out.println("ok");
                break;
            default:
                System.out.println("do nothing..");
        }
    }
}


// 因为 new Dog() 是静态加载，所以必须编写Dog
// Person类是动态加载，所以没有编写person类也不会报错