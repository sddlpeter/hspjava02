package com.hspedu.reflection;

import java.lang.reflect.Method;

public class ReflectionAccessMethod {
    public static void main(String[] args) throws Exception{
        Class<?> bossClass = Class.forName("com.hspedu.reflection.Boss");
        Object o = bossClass.newInstance();
        Method method = bossClass.getMethod("hi", String.class);
        // Method method1 = bossClass.getDeclaredMethod("hi");

        method.invoke(o, "tom");

        Method say = bossClass.getDeclaredMethod("say", int.class, String.class, char.class);
        say.setAccessible(true);
        String s = (String) say.invoke(o, 20, "Tom", 'T');
        String s2 = (String) say.invoke(null, 20, "Jerry", 'T');
        System.out.println(s2);

    }
}

class Boss {
    public int age;
    private  static String name;

    public Boss() {

    }

    private static String say(int n, String s, char c) {
        return n + " " + s + " " + c;
    }

    public void hi(String s) {
        System.out.println("hi " + s);
    }


}
