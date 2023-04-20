package com.hspedu.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Homework01 {
    public static void main(String[] args) throws Exception {
        Class<PrivateTest> cls = PrivateTest.class;
        Object o = cls.newInstance();
        Field name = cls.getDeclaredField("name");
        name.setAccessible(true);
        name.set(o, "helloJerry");
        Method method = cls.getMethod("getName");
        System.out.println(method.invoke(o));

    }
}

class PrivateTest {
    private String name = "helloKitty";
    public String getName() {
        return name;
    }
}