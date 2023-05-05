package com.ecommerce.user.repo;

import com.ecommerce.user.model.AccountMaster;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountMasterRepo extends JpaRepository<AccountMaster, Integer> {
}
