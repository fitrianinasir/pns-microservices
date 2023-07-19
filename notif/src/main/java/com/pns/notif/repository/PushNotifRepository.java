package com.pns.notif.repository;

import com.pns.notif.model.PushNotifModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PushNotifRepository extends JpaRepository<PushNotifModel, Integer> {
}
