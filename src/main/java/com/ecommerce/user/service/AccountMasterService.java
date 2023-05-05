package com.ecommerce.user.service;

import com.ecommerce.user.model.AccountMaster;
import com.ecommerce.user.repo.AccountMasterRepo;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountMasterService implements  IAccountMasterService{
    @Autowired
    AccountMasterRepo accountMasterRepo;

    @Override
    public void update(AccountMaster accountMaster) {
        accountMasterRepo.save(accountMaster);
    }
}
