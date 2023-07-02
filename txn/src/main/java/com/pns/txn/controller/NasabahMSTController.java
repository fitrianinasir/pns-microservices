package com.pns.txn.controller;

import com.pns.txn.dto.ResponseMessage;
import com.pns.txn.model.NasabahMSTModel;
import com.pns.txn.service.NasabahMSTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class NasabahMSTController {
    @Autowired
    NasabahMSTService nasabahMSTService;

    @GetMapping("/bank-customers")
    public @ResponseBody ResponseEntity<ResponseMessage> getAllBankCustomers(){
        ResponseMessage responseMessage = new ResponseMessage(200, "Retrieved Data Successfully", nasabahMSTService.getAllBankCustomers());
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @GetMapping("/bank-customer/{id}")
    public @ResponseBody ResponseEntity<ResponseMessage> getBankCustomerById(@PathVariable("id") Integer id){
        ResponseMessage responseMessage = new ResponseMessage<>(200, "Retrieved Data Successfully", nasabahMSTService.getBankCustomerById(id));
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PostMapping("/bank-customer/create")
    public @ResponseBody ResponseEntity<ResponseMessage> createBankCustomer(@RequestBody NasabahMSTModel nasabahMSTModel){
        ResponseMessage responseMessage = new ResponseMessage<>(200, "Created Data Successfully", nasabahMSTService.createBankCustomer(nasabahMSTModel));
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @PutMapping("/bank-customer/update/{id}")
    public @ResponseBody ResponseEntity<ResponseMessage> updateBankCustomer(@PathVariable("id") Integer id, @RequestBody NasabahMSTModel model){
        ResponseMessage responseMessage = new ResponseMessage<>(200, "Update Data Successfully", nasabahMSTService.updateBankCustomer(id, model));
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }

    @DeleteMapping("/bank-customer/{id}")
    public @ResponseBody ResponseEntity<ResponseMessage> deleteBankCustomer(@PathVariable("id") Integer id){
        ResponseMessage responseMessage = new ResponseMessage<>(200, "Update Data Successfully", nasabahMSTService.deleteBankCustomer(id));
        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
    }
}
