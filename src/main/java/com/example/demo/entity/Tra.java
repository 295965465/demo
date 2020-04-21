package com.example.demo.entity;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Description  
 * @Author  Sencheng
 * @Date 2020-03-30 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="M_TRA" )
public class Tra  implements Serializable {

	private static final long serialVersionUID =  5763897645732346609L;

   	@Column(name = "AMTCDR" )
	private String amtcdr;

   	@Column(name = "APDFLG" )
	private String apdflg;

   	@Column(name = "ATHFLG" )
	private String athflg;

   	@Column(name = "BBKNBR" )
	private String bbknbr;

   	@Column(name = "CHKNBR" )
	private String chknbr;

   	@Column(name = "C_ATHFLG" )
	private String cAthflg;

   	@Column(name = "C_BBKNBR" )
	private String cBbknbr;

   	@Column(name = "C_ETYDAT" )
	private String cEtydat;

   	@Column(name = "C_GSBBBK" )
	private String cGsbbbk;

   	@Column(name = "C_RPYBBK" )
	private String cRpybbk;

   	@Column(name = "C_TRSAMT" )
	private String cTrsamt;

   	@Column(name = "C_TRSAMTC" )
	private String cTrsamtc;

   	@Column(name = "C_TRSBLV" )
	private String cTrsblv;

   	@Column(name = "C_VLTDAT" )
	private String cVltdat;

   	@Column(name = "ETYDAT" )
	private String etydat;

   	@Column(name = "ETYTIM" )
	private String etytim;

   	@Column(name = "GSBBBK" )
	private String gsbbbk;

   	@Column(name = "NARYUR" )
	private String naryur;
    @Id
   	@Column(name = "REFNBR" )
	private String refnbr;

   	@Column(name = "REFSUB" )
	private String refsub;

   	@Column(name = "RPYACC" )
	private String rpyacc;

   	@Column(name = "RPYBBK" )
	private String rpybbk;

   	@Column(name = "RPYBNK" )
	private String rpybnk;

   	@Column(name = "RPYNAM" )
	private String rpynam;

   	@Column(name = "RSV30Z" )
	private String rsv30Z;

   	@Column(name = "RSV50Z" )
	private String rsv50Z;

   	@Column(name = "TRSAMT" )
	private String trsamt;

   	@Column(name = "TRSAMTC" )
	private String trsamtc;

   	@Column(name = "TRSANL" )
	private String trsanl;

   	@Column(name = "TRSBLV" )
	private String trsblv;

   	@Column(name = "TRSCOD" )
	private String trscod;

   	@Column(name = "YURREF" )
	private String yurref;

   	@Column(name = "FRMCOD" )
	private String frmcod;

   	@Column(name = "NAREXT" )
	private String narext;

   	@Column(name = "RSVFLG" )
	private String rsvflg;

	/**
	 * 用于标识收/付方帐号和母/子公司的信息。为空表示付方帐号和子公司；为"1"表示收方帐号和子公司；为"2"表示收方帐号和母公司；为"3"表示原收方帐号和子公司
	 */
   	@Column(name = "INFFLG" )
	private String infflg;

   	@Column(name = "RPYADR" )
	private String rpyadr;

   	@Column(name = "RPYBBN" )
	private String rpybbn;

   	@Column(name = "BUSNAR" )
	private String busnar;

   	@Column(name = "NUSAGE" )
	private String nusage;

   	@Column(name = "BUSNAM" )
	private String busnam;

   	@Column(name = "REQNBR" )
	private String reqnbr;

   	@Column(name = "TRSAMTD" )
	private String trsamtd;
	@Transient
   	private String myselfString;
	@Transient
	public String getMyselfString() {
		return this.etydat+""+this.etytim;
	}


}
