package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Auther: DELL
 * @Date: 2020/4/10 09:28
 * @Description:
 */

@Data
public class ArApEntity {
    private String traId;
    private String soNo;
    private String mbl;
    private String invoiceNo;
    private String tranNo;
    private String accountCode;
    private String accountCompanyName;
    private Date   postDate;
    private Date   invoiceDate;
    private Date   dueDate;
    private String transactionType;
    private String oJobInvoiceNumber;
    private String oNumber;
    private Date fullyPaidDate;
    private String localToTal;
    private String localCurrency;
    private String osTotal;
    private String outstandingAmount;
    private String osCurreny;

}
