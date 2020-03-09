package com.imooc.framework.aop;

public class ProxyDemo {
    public static void main(String[] args) {
        Payment proxy=new AliPay(new ReallPayment());
        proxy.pay();
    }
}
