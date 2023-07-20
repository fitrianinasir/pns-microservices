package com.pns.notif.service;

import com.pns.notif.model.TemplateModel;
import com.pns.notif.repository.TemplateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateService {
    @Autowired
    TemplateRepository templateRepository;

    public List<TemplateModel> getAllTemplate(){
        return templateRepository.findAll();
    }

    public Optional<TemplateModel> getTemplateById(Integer id){
        return templateRepository.findById(id);
    }

    public TemplateModel createTemplate(TemplateModel templateModel){
        return templateRepository.save(templateModel);
    }

    public TemplateModel updateTemplate(Integer id, TemplateModel templateModel){
        templateModel.setTemplate_id(id);
        return templateRepository.save(templateModel);
    }

    public void deleteTemplate(Integer id){
        templateRepository.deleteById(id);
    }
}
