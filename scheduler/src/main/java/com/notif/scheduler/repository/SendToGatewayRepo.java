package com.notif.scheduler.repository;

import com.notif.scheduler.model.NotifModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SendToGatewayRepo extends JpaRepository<NotifModel, Integer> {
}
