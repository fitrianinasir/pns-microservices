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
@Table(name = "TBL_NOTIF_TMP")
public class NotifTmpModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name="txn_reffno")
    private String txn_reffno;

    @Column(name="recipient")
    private String recipient;

    @Column(name="template_id")
    private Integer template_id;

    @Column(name="template_params")
    private String template_params;

    @Column(name = "flag")
    private String flag;
}
