package com.ecommerce.user.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "tbl_payment")
@Data
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id; //length 11

    @Column(name = "transaction_id")
    private  int transactionId; //transaction 11

    @Column(name = "total_payment")
    private BigDecimal totalPayment; //15,2 decimal

    @Column(name = "status_payment")
    private String statusPayment; // varchar 20

    @Column(name = "created_date")
    private Timestamp createdDate; //timestamp


}
