package com.pns.notif.dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class NotifData {
    private String txn_reffno;
    private String recipient;
    private String template_id;
    private String template_params;
    private String flag;
}
