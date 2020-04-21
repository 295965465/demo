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
 * @Description  非本人慎用！！！
 * @Author  Sencheng
 * @Date 2020-01-15 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="M_ACCOUNTING_TRANSACTION" )
public class AccountingTransaction  implements Serializable {

	private static final long serialVersionUID =  1327021593874717683L;
    @Id
   	@Column(name = "TRA_ID" )
	private String traId;

   	@Column(name = "DATASOURCE_TYPE" )
	private String datasourceType;

   	@Column(name = "PURPOSE_CODE" )
	private String purposeCode;

   	@Column(name = "DUEDATE" )
	private Date duedate;

   	@Column(name = "COMPLIANCE_NUMBER" )
	private String complianceNumber;

   	@Column(name = "JOBINVOICENUMBER" )
	private String jobinvoicenumber;

   	@Column(name = "ACCOUNT_CODE" )
	private String accountCode;

   	@Column(name = "ACCOUNT_COMPANYNAME" )
	private String accountCompanyname;

   	@Column(name = "POSTDATE" )
	private Date postdate;

   	@Column(name = "REQUISITIONDATE" )
	private Date requisitiondate;

   	@Column(name = "REQUISITIONSTATUS" )
	private String requisitionstatus;

   	@Column(name = "TRANSACTIONDATE" )
	private Date transactiondate;

   	@Column(name = "TRANSACTIONTYPE" )
	private String transactiontype;

   	@Column(name = "EVENTUSER" )
	private String eventuser;

   	@Column(name = "CREATED_DATE" )
	private Date createdDate;

   	@Column(name = "UPDATED_DATE" )
	private Date updatedDate;

   	@Column(name = "UPDATED_BY" )
	private String updatedBy;

   	@Column(name = "SEND_STATUS" )
	private String sendStatus;

   	@Column(name = "FILE_NAME" )
	private String fileName;

   	@Column(name = "O_JOBINVOICENUMBER" )
	private String oJobinvoicenumber;

   	@Column(name = "O_NUMBER" )
	private String oNumber;

   	@Column(name = "OUTSTANDING_AMOUNT" )
	private String outstandingAmount;

   	@Column(name = "FULLY_PAID_DATE" )
	private Date fullyPaidDate;

   	@Column(name = "IS_CANCELLED" )
	private String isCancelled;

   	@Column(name = "LOCAL_CURRENCY" )
	private String localCurrency;

   	@Column(name = "LOCAL_TOTAL" )
	private String localTotal;

   	@Column(name = "OS_CURRENCY" )
	private String osCurrency;

   	@Column(name = "LEDGER" )
	private String ledger;

   	@Column(name = "OS_TOTAL" )
	private String osTotal;

   	@Column(name = "O_TRANSACTIONREFERENCE" )
	private String oTransactionreference;

   	@Column(name = "TRANSACTIONREFERENCE" )
	private String transactionreference;

   	@Column(name = "RLS_OR_CLS_DATE" )
	private Date rlsOrClsDate;


}
