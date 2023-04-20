package com.hspedu.reflection;

import jdk.jfr.StackTrace;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {
    public static void main(String[] args) {

    }

    @Test
    public void api_01() throws Exception {
        Class<?> personCls = Class.forName("com.hspedu.reflection.Person");
        System.out.println(personCls.getName());  // com.hspedu.reflection.Person
        System.out.println(personCls.getSimpleName());

        System.out.println("===========================");

        Field[] fields = personCls.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }

        System.out.println("===========================");

        Field[] declaredFields = personCls.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }

        System.out.println("===========================");
        Method[] methods = personCls.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        System.out.println("===========================");
        Method[] declaredMethods = personCls.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println(declaredMethod.getName());
        }

        System.out.println("===========================");
        Constructor<?>[] constructors = personCls.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println(constructor.getName());
        }

        System.out.println("===========================");
        Constructor<?>[] declaredConstructors = personCls.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }

        System.out.println("===========================");

        System.out.println(personCls.getPackage());

        System.out.println("===========================");

        Class<?> superclass = personCls.getSuperclass();
        System.out.println(superclass);

        System.out.println("===========================");

        Class<?>[] interfaces = personCls.getInterfaces();
        for (Class<?> anInterface : interfaces) {
            System.out.println(anInterface);
        }

        System.out.println("===========================");
        Annotation[] annotations = personCls.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }
    }
}

class A {
    public String hobby;
    public A() {

    }

    public void hi() {

    }
}



interface IA{}
interface IB{}


@Deprecated
class Person extends A implements IA, IB{
    public String name;
    protected int age;
    String job;
    private double sal;

    public Person() {

    }
    public Person(String name) {
        this.name = name;
    }

    private Person(String name, int age) {

    }

    public void m1() {

    }

    protected void m2() {

    }

    void m3() {

    }

    private void m4() {

    }
}