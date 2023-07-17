package com.pns.txn.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TBL_NOTIFIKASI")
public class NotificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TXN_REFFNO")
    private String txn_reffno;

    @Column(name = "NO_REK")
    private Integer no_rek;

    @Column(name = "SENT_TIME")
    private String sent_time;

    @Column(name = "NAME")
    private String name;

    @Column(name = "NO_HP1")
    private String no_hp1;

    @Column(name = "NO_HP2")
    private String no_hp2;

    @Column(name = "EMAIL1")
    private String email1;

    @Column(name = "EMAIL2")
    private String email2;

    @Column(name = "RECIPIENT")
    private String recipient;

    @Column(name = "DELIVERY_STATUS")
    private String delivery_status;

    @Column(name = "GROUP_NAME")
    private String group_name;

    @Column(name = "TEMPLATE_ID")
    private Integer template_id;

    @Column(name = "TEMPLATE_PARAMS")
    private String template_params;

    @Column(name = "OPERATOR_CODE")
    private Integer operator_code;

}
