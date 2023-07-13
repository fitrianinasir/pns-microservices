package com.pns.notif.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "ftrnotif", groupId = "foo")
    void listener(String data){
        System.out.println("Lister received: " + data);
    }
}
