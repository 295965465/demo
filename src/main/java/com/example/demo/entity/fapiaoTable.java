package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Auther: DELL
 * @Date: 2019/10/21 15:41
 * @Description:  非本人慎用！！！
 */
@Data
@Entity
public class fapiaoTable {

    @Column(name = "DATASOURCE_TYPE" )
    private String dateSourceType;
    @Column(name = "COMPLIANCE_NUMBER" )
    private String complianceNumebr;
    @Column(name = "JOBINVOICENUMBER" )
    private String jobInvoiceNumebr;
    @Column(name = "ACCOUNT_CODE" )
    private String accountCode;
    @Column(name = "ACCOUNT_COMPANYNAME" )
    private String accountCompanyName;
    @Column(name = "DUEDATE" )
    private Date DueDate;
    @Column(name = "POSTDATE" )
    private Date postDate;
    @Column(name = "OUTSTANDING_AMOUNT" )
    private String outstandingAmount;
    @Column(name = "OS_TOTAL" )
    private String osTotal;
    @Column(name = "OS_CURRENCY" )
    private String osCurrency;
    @Column(name = "LOCAL_TOTAL" )
    private String localTotal;
    @Column(name = "LOCAL_CURRENCY" )
    private String loacaCurrency;
    @Id
    @Column(name = "TRA_ID" )
    private Integer TraId;
    @Column(name = "rownum_" )
    private Integer rownum_;
}
