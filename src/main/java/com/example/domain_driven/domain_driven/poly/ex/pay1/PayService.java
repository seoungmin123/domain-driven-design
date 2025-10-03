package com.example.domain_driven.domain_driven.poly.ex.pay1;

public class PayService {

    public void processPay(Pay pay, int amount) {
        System.out.println("결제를 시작합니다: option=" + pay + ", amount=" + amount);
        boolean result = pay.pay(amount);

        if (result) {
            System.out.println(pay + "결제가 성공했습니다.");
        } else {
            System.out.println(pay + "결제가 실패했습니다.");
        }
    }
}