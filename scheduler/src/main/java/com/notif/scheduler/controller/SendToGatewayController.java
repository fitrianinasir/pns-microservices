package com.notif.scheduler.controller;


import com.notif.scheduler.dto.INotifData;
import com.notif.scheduler.service.SendToGatewayService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SendToGatewayController {
    @Autowired
    SendToGatewayService gatewayService;

    @Value("${sendtogwrows}")
    public Integer rows;
    @GetMapping("/get-data")
    public List<INotifData> getData(){
        return gatewayService.sendToGW(rows);
    }
}
