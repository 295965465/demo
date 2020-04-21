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
 * @Date 2019-10-12 
 */

@Setter
@Getter
@ToString
@Entity
@Table ( name ="M_PAYMENT" )
public class Payment  implements Serializable {

	private static final long serialVersionUID =  7938146508257965663L;

	/**
	 * 付款单的内部编号
	 */
   	@Column(name = "P_NO" )
	private String pNo;

	/**
	 * N02021-直接支付；N02031-直接支付
N02040-集团支付 N02041－直接集团支付
	 */
   	@Column(name = "OP_STY" )
	private String opSty;

   	@Column(name = "OP_REFNO" )
	private String opRefno;

   	@Column(name = "OP_MODEID" )
	private String opModeid;

   	@Column(name = "OP_MODENAME" )
	private String opModename;

   	@Column(name = "PAY_ACCOUNT" )
	private String payAccount;

   	@Column(name = "PAY_ACCNAME" )
	private String payAccname;

   	@Column(name = "PAY_BANKAREAID" )
	private String payBankareaid;

   	@Column(name = "PAY_BANKAREANAME" )
	private String payBankareaname;

   	@Column(name = "TRA_MONEY" )
	private String traMoney;

   	@Column(name = "MON_TYPEIS" )
	private String monTypeis;

   	@Column(name = "MON_TYPE" )
	private String monType;

	/**
	 * N:普通
F：快速
	 */
   	@Column(name = "ACC_ID" )
	private String accId;

	/**
	 * 快速
普通
	 */
   	@Column(name = "ACC_NAME" )
	private String accName;

   	@Column(name = "PURPOSE" )
	private String purpose;

   	@Column(name = "EXP_DATE" )
	private Date expDate;

   	@Column(name = "EXP_TIME" )
	private Date expTime;

   	@Column(name = "OP_BRIEF" )
	private String opBrief;

   	@Column(name = "REC_ACCOUNTS" )
	private String recAccounts;

   	@Column(name = "REC_NAME" )
	private String recName;

   	@Column(name = "REC_BANKID" )
	private String recBankid;

   	@Column(name = "REC_OBANKID" )
	private String recObankid;

   	@Column(name = "REC_OBANKNAME" )
	private String recObankname;

   	@Column(name = "REC_OBANKADDRESS" )
	private String recObankaddress;

   	@Column(name = "REC_COUNTY" )
	private String recCounty;

   	@Column(name = "REC_EMAIL" )
	private String recEmail;

   	@Column(name = "REC_PHONENO" )
	private String recPhoneno;

   	@Column(name = "REC_ID" )
	private String recId;

   	@Column(name = "ACC_CHARGENO" )
	private String accChargeno;

   	@Column(name = "C_CREDIT" )
	private String cCredit;

   	@Column(name = "D_CREDIT" )
	private Date dCredit;

   	@Column(name = "C_CHECK1" )
	private String cCheck1;

   	@Column(name = "C_REFNO" )
	private String cRefno;

   	@Column(name = "D_CHECK1" )
	private Date dCheck1;

   	@Column(name = "C_UNCHECK" )
	private String cUncheck;

   	@Column(name = "D_UNCHECK" )
	private Date dUncheck;

   	@Column(name = "C_DEPOSE" )
	private String cDepose;

   	@Column(name = "D_DEPOSE" )
	private Date dDepose;

   	@Column(name = "C_COMMIT" )
	private String cCommit;

   	@Column(name = "D_COMMIT" )
	private Date dCommit;

	/**
	 * 标记单据状态（0 正常 1 已审核 2 已提交 9 已作废）
	 */
   	@Column(name = "D_CHECKMARK" )
	private String dCheckmark;

	/**
	 * 0 正常
1 已提交
2 银行返回的状态
	 */
   	@Column(name = "ST_PAY" )
	private String stPay;

   	@Column(name = "SUB_BANKNO" )
	private String subBankno;

   	@Column(name = "MON_BALANCE" )
	private String monBalance;

	/**
	 * C'代表贷方；'D'代表借方
	 */
   	@Column(name = "AMTCDR" )
	private String amtcdr;

	/**
	 * *代表冲账；X代表补帐
	 */
   	@Column(name = "RVSTAG" )
	private String rvstag;

   	@Column(name = "D_VAL" )
	private Date dVal;

   	@Column(name = "VOT_STYLE" )
	private String votStyle;

   	@Column(name = "VOT_DES" )
	private String votDes;

   	@Column(name = "VOT_NO" )
	private String votNo;

   	@Column(name = "SEQNBR" )
	private String seqnbr;

   	@Column(name = "TRA_SEQ" )
	private String traSeq;

   	@Column(name = "BRIEF" )
	private String brief;

   	@Column(name = "GSB_SUBBANKNO" )
	private String gsbSubbankno;

   	@Column(name = "GSB_ACCOUNTS" )
	private String gsbAccounts;

   	@Column(name = "GSB_NAME" )
	private String gsbName;

   	@Column(name = "GSB_OBNO" )
	private String gsbObno;

   	@Column(name = "GSB_OBNAME" )
	private String gsbObname;

   	@Column(name = "GSB_OPADDRESS" )
	private String gsbOpaddress;

	/**
	 * 为空表示付方帐号和子公司；为“1”表示收方帐号和子公司；为“2”表示收方帐号和母公司，一般用于判断收付方；对于集团公司，如果字段GSBACC不为空，也用于判断母子公司
	 */
   	@Column(name = "INFOMARK" )
	private String infomark;

   	@Column(name = "D_TRA" )
	private Date dTra;

   	@Column(name = "T_TRA" )
	private Date tTra;

   	@Column(name = "TRSANL" )
	private String trsanl;

	/**
	 * 暂时不用
	 */
   	@Column(name = "OPDATA" )
	private String opdata;

   	@Column(name = "SUBBANKAREAID" )
	private String subbankareaid;

   	@Column(name = "M_MONEY" )
	private String mMoney;

   	@Column(name = "D_OP" )
	private Date dOp;

   	@Column(name = "OP_RQRST" )
	private String opRqrst;

   	@Column(name = "OP_RSTDEC" )
	private String opRstdec;

   	@Column(name = "MEMO" )
	private String memo;

   	@Column(name = "BANK_ID" )
	private String bankId;

	/**
	 * Y 系统内 N 系统外
	 */
   	@Column(name = "IOROUT" )
	private String iorout;

	/**
	 * Y 同城 N 异地
	 */
   	@Column(name = "REGFLAG" )
	private String regflag;

	/**
	 * 结果摘要 业务处理结果
	 */
   	@Column(name = "RSTBRIEF" )
	private String rstbrief;

	/**
	 * 退票日期
	 */
   	@Column(name = "RTNDAT" )
	private Date rtndat;

	/**
	 * 经办用户登录名
	 */
   	@Column(name = "LGNNAM" )
	private String lgnnam;

	/**
	 * 经办用户姓名
	 */
   	@Column(name = "USRNAM" )
	private String usrnam;

	/**
	 * 银行业务编号
	 */
   	@Column(name = "BANK_ETURNID" )
	private String bankEturnid;

	/**
	 * 银行返回消息
	 */
   	@Column(name = "BANK_RETURNMSG" )
	private String bankReturnmsg;

	/**
	 * 制单用户所属公司
	 */
   	@Column(name = "USERCOMPANY" )
	private String usercompany;

   	@Column(name = "MSGTYP" )
	private String msgtyp;

   	@Column(name = "MSGNBR" )
	private String msgnbr;

   	@Column(name = "FLAG" )
	private String flag;

   	@Column(name = "CRTTIM" )
	private String crttim;

   	@Column(name = "RCVTIM" )
	private String rcvtim;

   	@Column(name = "EFTDAT" )
	private String eftdat;

   	@Column(name = "EXPDAT" )
	private String expdat;

	/**
	 * 客户ID
	 */
   	@Column(name = "CUSTOID" )
	private String custoid;

	/**
	 * 客户名称
	 */
   	@Column(name = "CUSTONAME" )
	private String custoname;

	/**
	 * 制单用户所属公司ID
	 */
   	@Column(name = "USERCOMPANYID" )
	private String usercompanyid;

   	@Column(name = "REC_PROV" )
	private String recProv;

   	@Column(name = "REC_CITY" )
	private String recCity;

   	@Column(name = "C_CHECK2" )
	private String cCheck2;

   	@Column(name = "D_CHECK2" )
	private Date dCheck2;

   	@Column(name = "C_CHECK3" )
	private String cCheck3;

   	@Column(name = "D_CHECK3" )
	private Date dCheck3;

	/**
	 * 主营业务 ，其他什么的
	 */
   	@Column(name = "PERTAG" )
	private String pertag;

	/**
	 * 发票信息
	 */
   	@Column(name = "INVOICE_INFO" )
	private String invoiceInfo;

	/**
	 * 保存几级审核即提交
	 */
   	@Column(name = "USERCHECK" )
	private String usercheck;

	/**
	 * 同步时间
	 */
   	@Column(name = "SYN_DATE" )
	private Date synDate;

	/**
	 * 提交日期
	 */
   	@Column(name = "CHECKINDATE" )
	private Date checkindate;

	/**
	 * m_ClearState 核销状态
	 */
   	@Column(name = "M_CLEARSTATE" )
	private String mClearstate;

   	@Column(name = "I_CLEARCHARGE" )
	private String iClearcharge;

	/**
	 * 联行号
	 */
   	@Column(name = "TOIBKN" )
	private String toibkn;
	/**
	 * 返回错误
	 */
	@Column(name="WEB_SUB_RES")
	private String webSubres;
	/**
	 * 发票关联 ID
	 */
   	@Column(name = "INVOICE_INFOID" )
	private String invoiceInfoid;
	@Column(name = "CACCOUNT_ID" )
	private Integer caccountid;
    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MY_SEQUENCE")
	@SequenceGenerator(name = "MY_SEQUENCE", sequenceName = "SEQ_M_CLEAR_HISTORY", initialValue = 0,
			allocationSize = 1)
	@Column(name = "PAYMENT_ID" )
   	private  Integer pamentId;

}
