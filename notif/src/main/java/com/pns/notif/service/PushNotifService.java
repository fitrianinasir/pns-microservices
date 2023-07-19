package com.pns.notif.service;

import com.pns.notif.dto.INotifData;
import com.pns.notif.dto.ITemplateBody;
import com.pns.notif.model.NotifTmpModel;
import com.pns.notif.model.PushNotifModel;
import com.pns.notif.repository.NotifTempRepository;
import com.pns.notif.repository.PushNotifRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PushNotifService {
    @Autowired
    NotifTempRepository notifTempRepository;

    @Autowired
    PushNotifRepository pushNotifRepository;

    public void pushNotification(NotifTmpModel notifTmpModel){
        notifTmpModel.setFlag("N");
        notifTempRepository.save(notifTmpModel);

    }

    public List<INotifData> sendToGW(){
        List<INotifData> data = notifTempRepository.selectToUpdate();
        for(INotifData i : data){
            ITemplateBody templateBody = notifTempRepository.getTemplateBody(i.getTemplate_Id());

            String body = templateBody.getTemplate_Body();
            String[] params = i.getTemplate_Params().split(";:;");
            for(String param : params){
                String out = body.substring(body.indexOf("[")+1,body.indexOf("]"));
                body = body.replace("["+out+"]", param);
            }

            PushNotifModel pushNotifModel = new PushNotifModel();
            pushNotifModel.setRecipient(i.getRecipient());
            pushNotifModel.setBody_message(body);
            pushNotifModel.setSent_status("SENT");
            pushNotifRepository.save(pushNotifModel);
            notifTempRepository.updateFlagData(i.getTxn_Reffno());
        }

        return data;
    }

}
