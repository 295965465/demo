package com.example.demo.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @Auther: DELL
 * @Date: 2019/10/21 15:41
 * @Description:
 */
@Data
@Entity
public class company {
    @Id
    @Column(name = "company_code" )
    private String companyCode;
    @Column(name = "company_name" )
    private String companyName;

}
