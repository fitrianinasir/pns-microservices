package com.pns.txn.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_nasabah_mst")
public class NasabahMSTModel {

    @Id
    @Column(name = "NO_REK_PK")
    private String NO_REK_PK;

    @Column(name = "BRANCH_CODE")
    private Integer BRANCH_CODE;

    @Column(name = "MEDIA_ID_PK")
    private Integer MEDIA_ID_PK;

    @Column(name = "NAME")
    private String NAME;

    @Column(name = "NO_HP1")
    private String NO_HP1;

    @Column(name = "NO_HP2")
    private String NO_HP2;

    @Column(name = "EMAIL1")
    private String EMAIL1;

    @Column(name = "EMAIL2")
    private String EMAIL2;

    @Column(name = "INPUT_DATE")
    private String INPUT_DATE;

    @Column(name = "STATUS_ACCOUNT")
    private String STATUS_ACCOUNT;

}
