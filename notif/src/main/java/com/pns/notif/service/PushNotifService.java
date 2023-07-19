package com.pns.notif.service;

import com.pns.notif.model.PushNotifModel;
import com.pns.notif.repository.PushNotifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PushNotifService {
    @Autowired
    PushNotifRepository pushNotifRepository;

    public void pushNotification(PushNotifModel pushNotifModel){
        pushNotifModel.setFlag("N");
        pushNotifRepository.save(pushNotifModel);
    }
}
