package com.ecommerce.user.service;

import com.ecommerce.user.model.AccountMaster;
import com.ecommerce.user.model.User;
import com.ecommerce.user.repo.AccountMasterRepo;
import com.ecommerce.user.repo.PaymentRepo;
import com.ecommerce.user.repo.UserRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractAuditable_;

import java.math.BigDecimal;

public class PaymentService {

    @Autowired
    PaymentRepo paymentRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    AccountMasterRepo accountMasterRepo;


    @Transactional
    public String payTransaction(String username, BigDecimal totalTxn){
        User user = userRepo.findUserByUsername(username);

        if(user.getBalance().compareTo(totalTxn) == -1) {
            return "failed";
        }

        user.setBalance(user.getBalance().subtract(totalTxn));

        AccountMaster accountMaster = accountMasterRepo.findAccountMasterByAccountNo("00000000001");
        accountMaster.setBalance(accountMaster.getBalance().add(totalTxn));

        return "Success";
    }

    public void receiveTrx(){

    }




}
