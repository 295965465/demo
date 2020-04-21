package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.util.Date;

/**
 * @Description  
 * @Author  Sencheng
 * @Date 2019-10-24 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="C_CUSTOMER_ACCOUNT" )
public class CustomerAccount  implements Serializable {

	private static final long serialVersionUID =  577841787147530543L;

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MY_SEQUENCE")
	@SequenceGenerator(name = "MY_SEQUENCE", sequenceName = "public_id", initialValue = 0,
			allocationSize = 1)
   	@Column(name = "CUSTOMER_ACCOUNT_ID" )
	private Integer customerAccountId;

   	@Column(name = "B_ACTIVE" )
	private String bActive;

   	@Column(name = "CUSTOMER_ID" )
	private String customerId;

   	@Column(name = "CURR_TYPE" )
	private String currType;

   	@Column(name = "BANK" )
	private String bank;

   	@Column(name = "BANK_NAME" )
	private String bankName;

   	@Column(name = "ACCOUNT_NAME" )
	private String accountName;

   	@Column(name = "ACCOUNT_NUMBER" )
	private String accountNumber;

   	@Column(name = "COUNTRY_CODE" )
	private String countryCode;

   	@Column(name = "PROVINCE_NAME" )
	private String provinceName;

   	@Column(name = "CITY_NAME" )
	private String cityName;

   	@Column(name = "CONTACT_NAME" )
	private String contactName;

   	@Column(name = "PHONE" )
	private String phone;

   	@Column(name = "EMAIL" )
	private String email;

   	@Column(name = "CREATE_BY" )
	private String createBy;

   	@Column(name = "CREATE_DATE" )
	private Date createDate;

   	@Column(name = "UPDATE_BY" )
	private String updateBy;

   	@Column(name = "UPDATE_DATE" )
	private Date updateDate;

   	@Column(name = "TOIBKN" )
	private String toibkn;

}
