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
 * @Date 2019-12-19 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="BD_BANKINFO" )
public class dBankinfo  implements Serializable {

	private static final long serialVersionUID =  941069804758074307L;

   	@Column(name = "BANK_ID" )
	@Id
	private String bankId;

   	@Column(name = "AREA" )
	private String area;

   	@Column(name = "AREA_ID" )
	private String areaId;

   	@Column(name = "BANK_NAME" )
	private String bankName;

   	@Column(name = "AREA_NAME" )
	private String areaName;

}
