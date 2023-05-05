package com.ecommerce.user.controller;

import com.ecommerce.user.repo.AccountMasterRepo;
import com.ecommerce.user.repo.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class RestPaymentController {
    @Autowired
    AccountMasterRepo accountMasterRepo;

    @Autowired
    PaymentRepo paymentRepo;
}
