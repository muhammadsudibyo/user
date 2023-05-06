package com.ecommerce.user.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PayTxnDTO {
    public int trxID;
    public String username;
    public BigDecimal totalTrx;
    public String status;
}
