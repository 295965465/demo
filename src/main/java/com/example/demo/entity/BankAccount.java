package com.example.demo.entity;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Auther: DELL  非本人慎用！！！
 * @Date: 2019/10/21 13:50
 * @Description:
 */

@Data
@Entity

public class BankAccount {
 @Id
 @Column(name = "currency_code" )
 private String currencyCode;
 @Column(name = "currency_name" )
 private String currebcyName;
 @Column(name = "edi_code" )
 private String ediCode;
 @Column(name = "edi_code2" )
 private String ediCode2;


}
