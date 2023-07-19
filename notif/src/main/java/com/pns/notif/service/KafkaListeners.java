package com.pns.notif.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pns.notif.model.PushNotifModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {
    @Autowired
    PushNotifService pushNotifService;

    @KafkaListener(topics = "ftrnotif", groupId = "foo")
    void listener(String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PushNotifModel values = mapper.readValue(data, PushNotifModel.class);
        pushNotifService.pushNotification(values);
    }
}
