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
 * @Date 2020-03-26 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="WEBBANKLOG" )
public class ebbanklog  implements Serializable {

	private static final long serialVersionUID =  2013239650303131560L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MY_log_s")
	@SequenceGenerator(name = "MY_log_s", sequenceName = "SEQ_M_SETTLEMENT", initialValue = 0,
			allocationSize = 1)
   	@Column(name = "ID" )
	private Integer id;

   	@Column(name = "USERCODE" )
	private String usercode;

   	@Column(name = "OPTIONS" )
	private String option;

   	@Column(name = "RUNTIME" )
	private String runtime;

   	@Column(name = "METHOD" )
	private String method;

   	@Column(name = "PARAMS" )
	private String params;

   	@Column(name = "IP" )
	private String ip;

   	@Column(name = "CREATETIME" )
	private Date createtime;

}
