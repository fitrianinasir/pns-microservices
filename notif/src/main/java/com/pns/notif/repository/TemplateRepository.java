package com.pns.notif.repository;

import com.pns.notif.model.TemplateModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TemplateRepository extends JpaRepository<TemplateModel, Integer> {
}
