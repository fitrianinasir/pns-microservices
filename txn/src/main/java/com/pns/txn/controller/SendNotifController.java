package com.pns.txn.controller;

import com.pns.txn.model.NotificationModel;
import com.pns.txn.service.SendNotifService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SendNotifController {
    @Autowired
    SendNotifService sendNotifService;

    @PostMapping("/push-notif")
    public void pushNotification(@RequestBody NotificationModel notificationModel){
        System.out.println(notificationModel.toString());
        NotificationModel result = sendNotifService.pushNotification(notificationModel);
        System.out.println(result);
    }
}
