package com.ecommerce.user.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "tbl_user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id; //id

    @Column(name = "username")
    private String username; //uniq

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "account_no")
    private String accountNo; //uniq

    @Column(name = "balance")
    private BigDecimal balance;

    @Column(name = "alamat")
    private String alamat;

    @Column(name = "is_delete")
    private String deleteFlag;

}
