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
 * @Description   非本人慎用！！！
 * @Author  Sencheng
 * @Date 2019-12-19 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="D_ACCOUNT" )
public class Account  implements Serializable {

	private static final long serialVersionUID =  1921909527692233338L;
    @Id
   	@Column(name = "D_ACCOUNT_ID" )
	private String dAccountId;

   	@Column(name = "ACCOUNT_SET" )
	private String accountSet;

   	@Column(name = "CURR_TYPE" )
	private String currType;

   	@Column(name = "BANK_NAME" )
	private String bankName;

   	@Column(name = "ACCOUNT_NAME" )
	private String accountName;

   	@Column(name = "ACCOUNT_NUMBER" )
	private String accountNumber;

   	@Column(name = "B_ENABLE" )
	private String bEnable;

   	@Column(name = "CREATE_BY" )
	private String createBy;

   	@Column(name = "CREATE_DATE" )
	private Date createDate;

   	@Column(name = "UPDATE_BY" )
	private String updateBy;

   	@Column(name = "UPDATE_DATE" )
	private Date updateDate;

   	@Column(name = "OP_AREA_NO" )
	private String opAreaNo;

   	@Column(name = "OP_AREA_NAME" )
	private String opAreaName;
	@Column(name = "CW_BANK_CODE" )
	private String webBankCode;

}
