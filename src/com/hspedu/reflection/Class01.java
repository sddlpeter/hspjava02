package com.hspedu.reflection;

import java.lang.reflect.Method;

public class Class01 {
    public static void main(String[] args) throws Exception {
        Class cls = Class.forName("com.hspedu.Cat");
        Object o = cls.newInstance();
        Method method = cls.getMethod("cry");

        method.invoke(o);

        Class cls2 = Class.forName("com.hspedu.Cat");
    }
}
