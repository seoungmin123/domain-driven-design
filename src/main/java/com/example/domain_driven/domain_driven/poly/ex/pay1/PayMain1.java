package com.example.domain_driven.domain_driven.poly.ex.pay1;

public class PayMain1 {
    public static void main(String[] args) {
        PayService payService = new PayService();

        //KakaoPay
        Pay kpay = new KakaoPay();
        int amount1 = 5000;
        payService.processPay(kpay, amount1);

        //naverPay
        Pay npay = new NaverPay();
        int amount2 = 5000;
        payService.processPay(npay, amount1);

        //DefaultPay
        Pay dpay = new DefaultPay();
        int amount3 = 5000;
        payService.processPay(dpay, amount1);

    }
}