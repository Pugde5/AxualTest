package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.axual.client.consumer.Consumer;

@RestController
public class MyController {
    @GetMapping("/push")
    public String pushStuff() {
        MyProducer producer = new MyProducer();
        producer.produceApplication();
        return "Done";
    }
    @GetMapping("/get")
    public String getStuff() {
        MyConsumer comsumer = new MyConsumer();
        try {
      comsumer.consume();
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
    e.printStackTrace();
    }
        return "Done";
    }
    
}
