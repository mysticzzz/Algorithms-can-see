package com.company.reflect;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectSample {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class rc=Class.forName("com.company.reflect.Robot");
        Robot r=(Robot) rc.newInstance();//做强转将它转为Robot类型,实例化Robot
        System.out.println("Class name is  "+rc.getName());
        Method getHello=rc.getDeclaredMethod("throwHello", String.class);//获取方法，不能获取继承的方法和实现的接口方法
        getHello.setAccessible(true);
        Object str=getHello.invoke(r,"Bob");
        System.out.println("getHello result is "+str);
        Method sayHi=rc.getMethod("sayHi", String.class);//只能获取共有方法，还可以获取继承类的，接口的公用方法
        sayHi.invoke(r,"Welcome");
        Field name=rc.getDeclaredField("name");
        name.setAccessible(true);
        name.set(r,"Alice");
        sayHi.invoke(r,"Welcome");
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }

}
