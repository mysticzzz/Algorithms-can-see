package com.company.reflect;

public class ClassLoaderChecker {
    public static void main(String[] args) throws ClassNotFoundException,IllegalAccessException,InstantiationException{
        MyClassLoader m=new MyClassLoader("D:/","myclassloader");
        Class c=m.loadClass("wali");
        System.out.println(c.getClassLoader());
        c.newInstance();
    }
}
