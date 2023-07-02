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
    public Optional<NasabahMSTModel> getBankCustomerById(Integer id){return nasabahMSTRepository.findById(id);}
    public NasabahMSTModel createBankCustomer(NasabahMSTModel nasabahMSTModel){
        System.out.println(nasabahMSTModel);
        Optional<NasabahMSTModel> custExisted = nasabahMSTRepository.findById(nasabahMSTModel.getNo_rek_pk());
        if(custExisted.isEmpty()) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
            Date date = new Date();
            nasabahMSTModel.setInput_date(dateFormat.format(date));
            nasabahMSTModel.setStatus_account("ACTIVE");
            System.out.println(nasabahMSTModel);
            return nasabahMSTRepository.save(nasabahMSTModel);
        }else{return null;}
    }
    public NasabahMSTModel updateBankCustomer(Integer id, NasabahMSTModel nasabahMSTModel){return nasabahMSTRepository.save(nasabahMSTModel);}
    public Integer deleteBankCustomer(Integer id){
        nasabahMSTRepository.deleteById(id);
        return null;
    }
}
