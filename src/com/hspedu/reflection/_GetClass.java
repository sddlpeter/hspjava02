package com.hspedu.reflection;

/**
 *
 */
public class _GetClass {
    public static void main(String[] args) throws Exception {
        // 1. Class.forName，多用于配置文件，读取类全路径加载类
        Class cls = Class.forName("com.hspedu.reflection.Car");
        System.out.println(cls);

        // 2.多用于参数传递，通过反射得到对应构造器对象
        Class cls2 = Car.class;
        System.out.println(cls2);

        // 3. 通过创建好的对象，获取Class对象
        Car car = new Car();
        Class cls3 = car.getClass();
        System.out.println(cls3);

        // 4. 通过类加载器
        ClassLoader classLoader = car.getClass().getClassLoader();
        Class cls4 = classLoader.loadClass("com.hspedu.reflection.Car");
        System.out.println(cls4);


        System.out.println(cls.hashCode());
        System.out.println(cls2.hashCode());
        System.out.println(cls3.hashCode());
        System.out.println(cls4.hashCode());

        Class<Integer> integerClass = int.class;
        Class<Character> characterClass = char.class;
        Class<Boolean> booleanClass = boolean.class;
        System.out.println(integerClass);

        Class<Integer> type = Integer.TYPE;
        Class<Character> type1 = Character.TYPE;
        System.out.println(type1);


    }
}
