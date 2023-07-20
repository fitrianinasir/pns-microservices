package com.pns.notif.controller;

import com.pns.notif.dto.responses.ResponseMessage;
import com.pns.notif.model.TemplateModel;
import com.pns.notif.service.TemplateService;
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
public class TemplateController {
    @Autowired
    TemplateService templateService;

    @GetMapping("/templates")
    public @ResponseBody ResponseEntity<ResponseMessage> getAllTemplate(){
        List<TemplateModel> templates = templateService.getAllTemplate();
        ResponseMessage responseMessage = new ResponseMessage(200, "All data retrieved successfully", templates);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/template/{id}")
    public @ResponseBody ResponseEntity<ResponseMessage> getTemplateById(@PathVariable("id") Integer id){
        Optional<TemplateModel> template = templateService.getTemplateById(id);
        ResponseMessage responseMessage = new ResponseMessage(200, "Template retrieved successfully", template);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PostMapping("/create-template")
    public @ResponseBody ResponseEntity<ResponseMessage> createTemplate(@RequestBody TemplateModel templateModel){
        TemplateModel new_template = templateService.createTemplate(templateModel);
        ResponseMessage responseMessage = new ResponseMessage(200, "Template created successfully", new_template);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PutMapping("/update-template/{id}")
    public @ResponseBody ResponseEntity<ResponseMessage> updateTemplate(@PathVariable("id") Integer id, @RequestBody TemplateModel templateModel){
        TemplateModel updated_template = templateService.updateTemplate(id, templateModel);
        ResponseMessage responseMessage = new ResponseMessage(200, "Template updated successfully", updated_template);
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping("/delete-template/{id}")
    public @ResponseBody ResponseEntity<ResponseMessage> deleteTemplate(@PathVariable("id") Integer id){
        templateService.deleteTemplate(id);
        ResponseMessage responseMessage = new ResponseMessage(200, "Template updated successfully", true );
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
