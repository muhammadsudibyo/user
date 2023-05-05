package com.ecommerce.user.repo;

import com.ecommerce.user.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
    Payment findPaymentById(Integer id);
}
