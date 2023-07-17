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
@Table(name = "TBL_NASABAH_MST")
public class NasabahMSTModel {
    @Id
    @Column(name = "no_rek_pk")
    private Integer no_rek_pk;

    @Column(name = "branch_code")
    private Integer branch_code;

    @Column(name = "media_id_pk")
    private Integer media_id_pk;

    @Column(name = "cust_name")
    private String cust_name;

    @Column(name = "no_hp1")
    private String no_hp1;

    @Column(name = "no_hp2")
    private String no_hp2;

    @Column(name = "email1")
    private String email1;

    @Column(name = "email2")
    private String email2;

    @Column(name = "input_date")
    private String input_date;

    @Column(name = "status_account")
    private String status_account;
}
