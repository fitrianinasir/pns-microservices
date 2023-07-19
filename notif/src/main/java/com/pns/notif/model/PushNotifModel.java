package com.pns.notif.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "TBL_NOTIF_REPORT_GW")
public class PushNotifModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "recipient")
    private String recipient;

    @Column(name = "body_message")
    private String body_message;

    @Column(name = "sent_status")
    private String sent_status;
}
