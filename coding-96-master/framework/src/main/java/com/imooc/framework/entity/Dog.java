package com.imooc.framework.entity;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Pet{
    @Override
    public void move(){
        System.out.println("I am a dog,my name is QYY");
    }
}
