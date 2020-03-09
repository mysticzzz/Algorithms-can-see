package com.imooc.framework.aop;

public class AliPay implements Payment{
    private Payment payment;

    public AliPay(Payment payment){
        this.payment=payment;
    }
    public void beforePay(){
        System.out.println("从支行取款");
    }
    @Override
    public void pay(){
        beforePay();
        payment.pay();
        afferPay();

    }

    public void afferPay(){
        System.out.println("支付给QYY");
    }
}
