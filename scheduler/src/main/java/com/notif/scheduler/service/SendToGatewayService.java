package com.notif.scheduler.service;


import com.notif.scheduler.dto.INotifData;
import com.notif.scheduler.dto.ITemplateBody;
import com.notif.scheduler.model.NotifTmpModel;
import com.notif.scheduler.model.NotifModel;
import com.notif.scheduler.repository.NotifTempRepository;
import com.notif.scheduler.repository.SendToGatewayRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SendToGatewayService {
    @Autowired
    NotifTempRepository notifTempRepository;

    @Autowired
    SendToGatewayRepo sendToGatewayRepo;

    public void pushNotification(NotifTmpModel notifTmpModel){
        notifTmpModel.setFlag("N");
        notifTempRepository.save(notifTmpModel);

    }

    public List<INotifData> sendToGW(Integer rows){
        List<INotifData> data = notifTempRepository.selectToUpdate(rows);
        for(INotifData i : data){
            ITemplateBody templateBody = notifTempRepository.getTemplateBody(i.getTemplate_Id());

            String body = templateBody.getTemplate_Body();
            String[] params = i.getTemplate_Params().split(";:;");
            for(String param : params){
                String out = body.substring(body.indexOf("[")+1,body.indexOf("]"));
                body = body.replace("["+out+"]", param);
            }

            NotifModel notifModel = new NotifModel();
            notifModel.setRecipient(i.getRecipient());
            notifModel.setBody_message(body);
            notifModel.setSent_status("SENT");
            sendToGatewayRepo.save(notifModel);
            notifTempRepository.updateFlagData(i.getTxn_Reffno());
        }

        return data;
    }

}
