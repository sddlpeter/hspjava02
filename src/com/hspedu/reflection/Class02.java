package com.hspedu.reflection;

import java.lang.reflect.Field;

public class Class02 {
    public static void main(String[] args) throws Exception {
        String classAllPath = "com.hspedu.reflection.Car";

        Class cls = Class.forName(classAllPath);
        System.out.println(cls);
        System.out.println(cls.getClass()); // 输出运行类型, java.lang.Class
        System.out.println(cls.getPackage().getName());
        System.out.println(cls.getName());

        Car car = (Car) cls.newInstance();
        System.out.println(car);

        Field field = cls.getField("brand");
        System.out.println(field.get(car));

        field.set(car, "Benz");
        System.out.println(field.get(car));

        Field[] fields = cls.getFields();
        for (int i = 0; i < fields.length; i++) {
            System.out.println(fields[i].getName());
        }

    }
}
