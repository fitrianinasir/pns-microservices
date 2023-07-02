package com.pns.txn.controller;

import com.pns.txn.dto.ResponseMessage;
import com.pns.txn.model.NasabahMSTModel;
import com.pns.txn.service.NasabahMSTService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        Optional<NasabahMSTModel> result = nasabahMSTService.getBankCustomerById(id);
        if(result.isPresent()) {
            ResponseMessage responseMessage = new ResponseMessage<>(200, "Retrieved Data Successfully", result);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }else{
            ResponseMessage responseMessage = new ResponseMessage<>(422, "Data is not exist", null);
            return new ResponseEntity<>(responseMessage, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PostMapping("/bank-customer/create")
    public @ResponseBody ResponseEntity<ResponseMessage> createBankCustomer(@RequestBody NasabahMSTModel nasabahMSTModel){
        NasabahMSTModel result =  nasabahMSTService.createBankCustomer(nasabahMSTModel);
        if(result != null){
            ResponseMessage responseMessage = new ResponseMessage<>(200, "Created Data Successfully", result);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }else{
            ResponseMessage responseMessage = new ResponseMessage<>(422, "NO_REK has been registered", null);
            return new ResponseEntity<>(responseMessage, HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @PutMapping("/bank-customer/update/{id}")
    public @ResponseBody ResponseEntity<ResponseMessage> updateBankCustomer(@PathVariable("id") Integer id, @RequestBody NasabahMSTModel model){
        NasabahMSTModel result = nasabahMSTService.updateBankCustomer(id, model);
        if(result != null){
            ResponseMessage responseMessage = new ResponseMessage<>(200, "Update Data Successfully", result);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }else{
            ResponseMessage responseMessage = new ResponseMessage<>(422, "Data is not exist", null);
            return new ResponseEntity<>(responseMessage, HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @DeleteMapping("/bank-customer/{id}")
    public @ResponseBody ResponseEntity<ResponseMessage> deleteBankCustomer(@PathVariable("id") Integer id){
        Boolean result = nasabahMSTService.deleteBankCustomer(id);
        if(result == true){
            ResponseMessage responseMessage = new ResponseMessage<>(200, "Data Deleted Successfully", true);
            return new ResponseEntity<>(responseMessage, HttpStatus.OK);
        }else{
            ResponseMessage responseMessage = new ResponseMessage<>(422, "Data is not exist", false);
            return new ResponseEntity<>(responseMessage, HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }
}
