package com.pns.txn.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PushNotifRequest {
    private String txn_reffno;
    private String recipient;
    private Integer template_id;
    private String template_params;

}
