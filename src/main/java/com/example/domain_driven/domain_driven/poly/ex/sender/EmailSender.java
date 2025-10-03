package com.example.domain_driven.domain_driven.poly.ex.sender;

public class EmailSender implements Sender {
    @Override
    public void sendMessage(String s) {
        System.out.println("메일을 발송합니다 : " + s);

    }
}
