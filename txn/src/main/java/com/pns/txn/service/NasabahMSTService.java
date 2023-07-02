package com.pns.txn.service;

import com.pns.txn.model.NasabahMSTModel;
import com.pns.txn.repository.NasabahMSTRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class NasabahMSTService {
    @Autowired
    NasabahMSTRepository nasabahMSTRepository;

    public List<NasabahMSTModel> getAllBankCustomers(){return nasabahMSTRepository.findAll();}
    public Optional<NasabahMSTModel> getBankCustomerById(Integer id){
        return nasabahMSTRepository.findById(id);
    }
    public NasabahMSTModel createBankCustomer(NasabahMSTModel nasabahMSTModel){
        Optional<NasabahMSTModel> custExisted = nasabahMSTRepository.findById(nasabahMSTModel.getNo_rek_pk());
        if(custExisted.isEmpty()) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            Date date = new Date();
            nasabahMSTModel.setInput_date(dateFormat.format(date));
            nasabahMSTModel.setStatus_account("ACTIVE");
            return nasabahMSTRepository.save(nasabahMSTModel);
        }else{return null;}
    }
    public NasabahMSTModel updateBankCustomer(Integer id, NasabahMSTModel nasabahMSTModel){
        Optional<NasabahMSTModel> custExisted = nasabahMSTRepository.findById(id);
        if(custExisted.isPresent()){
            return nasabahMSTRepository.save(nasabahMSTModel);
        }else{
            return null;
        }

    }
    public Boolean deleteBankCustomer(Integer id){
        Optional<NasabahMSTModel> custExisted = nasabahMSTRepository.findById(id);
        if(custExisted.isPresent()){
            nasabahMSTRepository.deleteById(id);
            return true;
        }else{
            return false;
        }

    }
}
