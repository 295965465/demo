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
 * @Date 2019-12-27 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="P_USER" )
public class User  implements Serializable {

	private static final long serialVersionUID =  8668244001126043445L;

   	@Column(name = "USER_CODE" )
	@Id
	private String userCode;

   	@Column(name = "USER_FULLNAME" )
	private String userFullname;

   	@Column(name = "USER_SHORTCODE" )
	private String userShortcode;

   	@Column(name = "USER_PWD" )
	private String userPwd;

   	@Column(name = "USER_TYPE" )
	private String userType;

   	@Column(name = "COMPANY_CODE" )
	private String companyCode;

   	@Column(name = "B_ENABLED" )
	private String bEnabled;

   	@Column(name = "DEPARTMENT_CODE" )
	private String departmentCode;

   	@Column(name = "TEAM_CODE" )
	private String teamCode;

   	@Column(name = "MANAGE_LEVEL" )
	private String manageLevel;

   	@Column(name = "TELE" )
	private String tele;

   	@Column(name = "FAX" )
	private String fax;

   	@Column(name = "MOBILE" )
	private String mobile;

   	@Column(name = "ADDRESS" )
	private String address;

   	@Column(name = "USER_ACCOUNT_NO" )
	private String userAccountNo;

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

   	@Column(name = "LAST_TEU" )
	private String lastTeu;

}
