package com.pns.txn.service;

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

    private KafkaTemplate<String, String> kafkaTemplate;

    public SendNotifService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public NotificationModel pushNotification(NotificationModel notificationModel){
        PushNotifRequest pushNotifRequest = new PushNotifRequest();
        pushNotifRequest.setTxn_reffno(notificationModel.getTxn_reffno());
        pushNotifRequest.setRecipient(notificationModel.getRecipient());
        pushNotifRequest.setTemplate_id(notificationModel.getTemplate_id());
        pushNotifRequest.setTemplate_params(notificationModel.getTemplate_params());

        kafkaTemplate.send("ftrnotif", pushNotifRequest.toString());
        return notificationRepository.save(notificationModel);
    }
}
