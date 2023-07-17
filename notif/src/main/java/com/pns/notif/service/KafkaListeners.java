package com.pns.notif.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pns.notif.dto.PushNotifData;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListeners {

    @KafkaListener(topics = "ftrnotif", groupId = "foo")
    void listener(String data) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        PushNotifData values = mapper.readValue(data, PushNotifData.class);
        System.out.println("Mapping to POJO: " + values.getTxn_reffno() + values.getRecipient());
        System.out.println("Lister received: " + data);
    }
}
