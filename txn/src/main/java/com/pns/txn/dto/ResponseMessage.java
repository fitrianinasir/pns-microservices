package com.pns.txn.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseMessage<T> {
    private Integer status;
    private String message;
    private T data;


    public ResponseMessage(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
