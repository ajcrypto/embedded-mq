package com.example.embeddedmq;


import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {


    @JmsListener(destination="artemisQueue")
    public void consume(String message){

        System.out.println("Message is :" + message);

    }

}
