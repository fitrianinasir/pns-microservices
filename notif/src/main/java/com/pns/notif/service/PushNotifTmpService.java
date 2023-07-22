package com.pns.notif.service;

import com.pns.notif.model.NotifTmpModel;
import com.pns.notif.repository.NotifTempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PushNotifTmpService {
    @Autowired
    NotifTempRepository notifTempRepository;

    public void pushNotification(NotifTmpModel notifTmpModel){
        notifTmpModel.setFlag("N");
        notifTempRepository.save(notifTmpModel);
    }

    public List<NotifTmpModel> getAllTmpNotif(){
        return notifTempRepository.findAll();
    }

    public Optional<NotifTmpModel> getTmpNotifById(Integer id){
        return notifTempRepository.findById(id);
    }

}
