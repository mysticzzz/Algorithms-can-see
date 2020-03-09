package com.imooc.framework.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping (value="hello",method= RequestMethod.GET)
    @ResponseBody
    public String hello(){
        String sentence="hello world";
        System.out.println(sentence);
        return sentence;
    }
    @RequestMapping (value="hi",method= RequestMethod.GET)
    @ResponseBody
    public String hi(){
        String sentence="hello world";
        System.out.println(sentence);
        return sentence;
    }
}
