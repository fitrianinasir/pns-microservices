package com.pns.notif.controller;

import com.pns.notif.dto.INotifData;
import com.pns.notif.dto.NotifData;
import com.pns.notif.service.PushNotifService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class PushNotifController {
    @Autowired
    PushNotifService pushNotifService;

    @GetMapping("/get-data")
    public List<INotifData> getData(){
        return pushNotifService.sendToGW();
    }
}
