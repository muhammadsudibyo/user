package com.ecommerce.user.service;

import com.ecommerce.user.kafka.KafkaProducerSystem;
import com.ecommerce.user.model.AccountMaster;
import com.ecommerce.user.model.PayTxnDTO;
import com.ecommerce.user.model.User;
import com.ecommerce.user.repo.AccountMasterRepo;
import com.ecommerce.user.repo.UserRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractAuditable_;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PaymentService {


    @Autowired
    UserRepo userRepo;

    @Autowired
    AccountMasterRepo accountMasterRepo;

    @Autowired private KafkaProducerSystem sender;


    @Transactional
    public String payTransaction(String username, BigDecimal totalTxn){
        User user = userRepo.findUserByUsername(username);

        if(user.getBalance().compareTo(totalTxn) == -1) {
            return "failed";
        }
        user.setBalance(user.getBalance().subtract(totalTxn));
        userRepo.save(user);

        AccountMaster accountMaster = accountMasterRepo.findAccountMasterByAccountNo("00000000001");
        accountMaster.setBalance(accountMaster.getBalance().add(totalTxn));
        accountMasterRepo.save(accountMaster);
        return "Success";
    }

    //receive kafka
    @KafkaListener(topics = "execute_Transaction", groupId = "test-consumer-group")
    public void receiveTrx(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        PayTxnDTO  payTxnDTO = objectMapper.readValue(json, PayTxnDTO.class);
        System.out.println("disiniiiii ceeeeeeek payTxnDTO = " + payTxnDTO);
        String status = this.payTransaction(payTxnDTO.getUsername(), payTxnDTO.getTotalTrx());
        payTxnDTO.setStatus(status);
        this.sendTrxStatus(payTxnDTO);
    }

    //send kafka
    public void sendTrxStatus(PayTxnDTO payTxnDTO) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(payTxnDTO);
        System.out.println("disiniiiii seeeeeeeeend payTxnDTO = " + payTxnDTO);
        sender.send("status_Transaction", json);
    }




}
