package com.ecommerce.user.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_account_master")
@Data
public class AccountMaster {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") //length 11
    private int id;

    @Column(name = "account_no") //account_no 11
    private String accountNo;

    @Column(name = "account_name") //account_name 20
    private String accountName;

    @Column(name = "balance") // 15,2
    private BigDecimal balance;
}
