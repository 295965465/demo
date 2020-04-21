package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

/**
 * @Description  
 * @Author  Sencheng
 * @Date 2020-01-15 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="COMPANY_PROFILE" )
public class CompanyProfile implements Serializable {

	private static final long serialVersionUID =  6191501755994147435L;
	@Id
   	@Column(name = "COMPANY_CODE" )
	private String companyCode;

   	@Column(name = "COMPANY_NAME" )
	private String companyName;

   	@Column(name = "B_ACCOUNT_SLOT" )
	private String bAccountSlot;

   	@Column(name = "PARENT_COMPANY_CODE" )
	private String parentCompanyCode;

   	@Column(name = "SHORT_NAME" )
	private String shortName;

   	@Column(name = "ADDITIONAL_NAME" )
	private String additionalName;

   	@Column(name = "JOB_PREFIX" )
	private String jobPrefix;

   	@Column(name = "LAST_JOBNO_SEQ" )
	private String lastJobnoSeq;

   	@Column(name = "CRID" )
	private String crid;

   	@Column(name = "COUNTRY_CODE" )
	private String countryCode;

   	@Column(name = "TELE" )
	private String tele;

   	@Column(name = "PROVINCE" )
	private String province;

   	@Column(name = "CITY" )
	private String city;

   	@Column(name = "FAX" )
	private String fax;

   	@Column(name = "EMAIL" )
	private String email;

   	@Column(name = "POST_CODE" )
	private String postCode;

   	@Column(name = "ADDRESS" )
	private String address;

   	@Column(name = "MANAGER_NAME" )
	private String managerName;

   	@Column(name = "BUSINESS_SEAL" )
	private String businessSeal;

   	@Column(name = "BUSINESS_REG" )
	private String businessReg;

   	@Column(name = "TAX_REG" )
	private String taxReg;

   	@Column(name = "REMARK" )
	private String remark;

   	@Column(name = "CREATE_BY" )
	private String createBy;

   	@Column(name = "CREATE_DATE" )
	private Date createDate;

   	@Column(name = "UPDATE_BY" )
	private String updateBy;

   	@Column(name = "UPDATE_DATE" )
	private Date updateDate;

   	@Column(name = "ACCOUNT_INFO" )
	private String accountInfo;

   	@Column(name = "LOCAL_CURR" )
	private String localCurr;

}
