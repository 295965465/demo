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
 * @Date 2020-02-11 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="BD_BANK" )
public class dBank  implements Serializable {

	private static final long serialVersionUID =  4982857335523808601L;
    @Id
   	@Column(name = "BANK_NO" )
	private String bankNo;

   	@Column(name = "BANK_NAME" )
	private String bankName;

   	@Column(name = "P_BANKNO" )
	private String pBankno;

   	@Column(name = "AREA" )
	private String area;

   	@Column(name = "P_BANKNAME" )
	private String pBankname;

   	@Column(name = "AREA_ID" )
	private String areaId;

}
