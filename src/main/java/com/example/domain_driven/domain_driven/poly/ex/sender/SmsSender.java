package com.example.domain_driven.domain_driven.poly.ex.sender;

public class SmsSender implements Sender {
    @Override
    public void sendMessage(String s) {
        System.out.println("SMS를 발송합니다 : " + s);
    }
}
