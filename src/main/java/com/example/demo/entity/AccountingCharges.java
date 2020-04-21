package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  Sencheng
 * @Date 2020-04-15 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="M_ACCOUNTING_CHARGES" )
public class AccountingCharges  implements Serializable {

	private static final long serialVersionUID =  8391012178583464859L;
	@Id
   	@Column(name = "CHARGE_ID" )
	private String chargeId;

   	@Column(name = "TRA_ID" )
	private String traId;

   	@Column(name = "BRANCH_CODE" )
	private String branchCode;

   	@Column(name = "CHARGECODE" )
	private String chargecode;

   	@Column(name = "CHARGEDESCRIPTION" )
	private String chargedescription;

   	@Column(name = "CHARGECURRENCY" )
	private String chargecurrency;

   	@Column(name = "CHARGEEXCHANGERATE" )
	private String chargeexchangerate;

   	@Column(name = "CHARGETOTALAMOUNT" )
	private String chargetotalamount;

   	@Column(name = "CHARGETOTALEXVATAMOUNT" )
	private String chargetotalexvatamount;

   	@Column(name = "JOB_NUMBER" )
	private String jobNumber;

   	@Column(name = "LOCALAMOUNT" )
	private String localamount;

   	@Column(name = "LOCALCURRENCY" )
	private String localcurrency;

   	@Column(name = "LOCALGSTVATAMOUNT" )
	private String localgstvatamount;

   	@Column(name = "LOCALTOTALAMOUNT" )
	private String localtotalamount;

   	@Column(name = "OSAMOUNT" )
	private String osamount;

   	@Column(name = "OSCURRENCY" )
	private String oscurrency;

   	@Column(name = "OSGSTVATAMOUNT" )
	private String osgstvatamount;

   	@Column(name = "OSTOTALAMOUNT" )
	private String ostotalamount;

   	@Column(name = "TRANSACTIONTYPE" )
	private String transactiontype;

}
