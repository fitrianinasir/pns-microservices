package com.pns.notif.controller;

import com.pns.notif.dto.responses.ResponseMessage;
import com.pns.notif.model.NotifTmpModel;
import com.pns.notif.service.PushNotifTmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class PushNotifTmpController {
    @Autowired
    PushNotifTmpService pushNotifTmpService;

    @GetMapping("/all-notif-tmp")
    public @ResponseBody ResponseEntity<ResponseMessage> getAllTmpNotif(){
        List<NotifTmpModel> notifs = pushNotifTmpService.getAllTmpNotif();
        ResponseMessage responseMessage = new ResponseMessage(200, "All data retrieved successfully", notifs);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/notif-tmp/{id}")
    public @ResponseBody ResponseEntity<ResponseMessage> getTmpNotifById(@PathVariable("id") Integer id){
        Optional<NotifTmpModel> notif = pushNotifTmpService.getTmpNotifById(id);
        ResponseMessage responseMessage = new ResponseMessage(200, "All data retrieved successfully", notif);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
