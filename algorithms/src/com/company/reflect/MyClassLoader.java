package com.company.reflect;

import java.io.*;
import java.util.InputMismatchException;

public class MyClassLoader extends ClassLoader{
    private String path;
    private String classLoaderName;

    public MyClassLoader(String path,String classLoaderName){
        this.classLoaderName=classLoaderName;
        this.path=path;
    }

    //用于寻找类文件
    @Override
    public Class findClass(String name){
        byte[] b=loadClassData(name);
        return defineClass(name,b,0,b.length);//返回整个文件的字节流,将字节码转换为class
    }
    /*findClass()
    根据名称或位置加载.class字节码,然后使用defineClass*/
    //用于加载类文件
    private byte[] loadClassData(String name){
        name=path+name+".class";
        InputStream in=null;//输入
        ByteArrayOutputStream out=null;//输出
        try{
            in=new FileInputStream(new File(name));
            out=new ByteArrayOutputStream();
            int i=0;
            while((i=in.read())!=-1){
                out.write(i);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally {
          try {
              out.close();
              in.close();
          }catch(Exception e){
                e.printStackTrace();
            }
        }
        return out.toByteArray(); //返回字节码二进制流数组
    }
}
