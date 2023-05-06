package com.ecommerce.user.controller;

import com.ecommerce.user.model.Payment;
import com.ecommerce.user.model.User;
import com.ecommerce.user.repo.AccountMasterRepo;
import com.ecommerce.user.repo.PaymentRepo;
import com.ecommerce.user.util.AccountNumberGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("payment")
public class RestPaymentController {
    @Autowired
    AccountMasterRepo accountMasterRepo;

    @Autowired
    PaymentRepo paymentRepo;

    //Add User
    @PostMapping("/add")
    @ResponseStatus(HttpStatus.OK)
    public Payment addPayment(@RequestBody Payment payment){
        return paymentRepo.save(payment);
    }
}
