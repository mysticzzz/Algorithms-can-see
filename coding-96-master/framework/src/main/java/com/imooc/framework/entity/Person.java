package com.imooc.framework.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("person")
public class Person {
    @Value("Jack")
    public String name;
    @Autowired
    private Pet pet;

    public void call(){
        pet.move();
    }


}
