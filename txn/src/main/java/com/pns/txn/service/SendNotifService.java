package com.pns.txn.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pns.txn.dto.PushNotifRequest;
import com.pns.txn.model.NotificationModel;
import com.pns.txn.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SendNotifService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    private ObjectMapper objectMapper;

    private KafkaTemplate<String, String> kafkaTemplate;

    public SendNotifService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public NotificationModel pushNotification(NotificationModel notificationModel) throws JsonProcessingException {
        PushNotifRequest pushNotifRequest = new PushNotifRequest();
        pushNotifRequest.setTxn_reffno(notificationModel.getTxn_reffno());
        pushNotifRequest.setRecipient(notificationModel.getRecipient());
        pushNotifRequest.setTemplate_id(notificationModel.getTemplate_id());
        pushNotifRequest.setTemplate_params(notificationModel.getTemplate_params());
        String notifObj = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(pushNotifRequest);
        kafkaTemplate.send("ftrnotif", notifObj);
        return notificationRepository.save(notificationModel);
    }
}
