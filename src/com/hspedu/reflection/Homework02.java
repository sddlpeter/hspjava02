package com.hspedu.reflection;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Homework02 {
    public static void main(String[] args) throws Exception {
        // Class<File> fileClass = File.class;
        Class<?> file = Class.forName("java.io.File");
        Constructor<?>[] constructors = file.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor);
        }
        Constructor<?> constructor = file.getConstructor(String.class);
        Object o = constructor.newInstance("c:\\javaio\\mynew.txt");
        Method m = file.getMethod("createNewFile");
        m.invoke(o);
    }
}
