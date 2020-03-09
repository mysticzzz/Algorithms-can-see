package com.imooc.framework.aop;

public class ReallPayment implements Payment{
    @Override
    public void pay(){
        System.out.println("作为用户，我只关心支付功能");
    }
}
