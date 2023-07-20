package com.pns.notif.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "TBL_TEMPLATE")
public class TemplateModel {

    @Id
    @Column(name = "template_id")
    private Integer template_id;

    @Column(name = "template_name")
    private String template_name;

    @Column(name = "template_body")
    private String template_body;
}
