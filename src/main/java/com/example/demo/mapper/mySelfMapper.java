package com.example.demo.mapper;

import com.example.demo.entity.fapiaoTable;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.StatementType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Auther: DELL
 * @Date: 2019/10/24 16:20
 * @Description:
 */
@Mapper
public interface mySelfMapper {
    @Select("select A.DATASOURCE_TYPE,A.COMPLIANCE_NUMBER,A.JOBINVOICENUMBER,A.ACCOUNT_CODE,A.ACCOUNT_COMPANYNAME,DUEDATE,A.POSTDATE,\n" +
            "       -A.OUTSTANDING_AMOUNT AS OUTSTANDING_AMOUNT,-A.OS_TOTAL AS OS_TOTAL,A.OS_CURRENCY,-A.LOCAL_TOTAL AS LOCAL_TOTAL,A.LOCAL_CURRENCY,A.TRA_ID\n" +
            "  from M_ACCOUNTING_TRANSACTION A\n" +
            " where A.DATASOURCE_TYPE like 'AP INV%'\n" +
            "   AND (WEB_BANK='N' OR WEB_BANK IS NULL)\n" +
            "   AND lower(IS_CANCELLED) != 'true'\n" +
            "   AND FULLY_PAID_DATE is null\n" +
            "   AND EXISTS(SELECT * FROM CW_BRANCH_INFORMATION B,M_ACCOUNTING_CHARGES C WHERE B.company_branch_code=C.branch_code AND B.company_code='SHA' AND A.TRA_ID=C.tra_id)\n")
    List<fapiaoTable> getAllfapiaoTable();

    @Select("select A.DATASOURCE_TYPE as DATASOURCE_TYPE ,A.COMPLIANCE_NUMBER as COMPLIANCE_NUMBER,A.JOBINVOICENUMBER as JOBINVOICENUMBER,A.ACCOUNT_CODE as ACCOUNT_CODE,A.ACCOUNT_COMPANYNAME,DUEDATE,A.POSTDATE,\n" +
            "       -A.OUTSTANDING_AMOUNT AS OUTSTANDING_AMOUNT,-A.OS_TOTAL AS OS_TOTAL,A.OS_CURRENCY,-A.LOCAL_TOTAL AS LOCAL_TOTAL,A.LOCAL_CURRENCY,A.TRA_ID\n" +
            "  from M_ACCOUNTING_TRANSACTION A\n" +
            " where A.DATASOURCE_TYPE like 'AP INV%'\n" +
            "   AND (WEB_BANK='N' OR WEB_BANK IS NULL)\n" +
            "   AND lower(IS_CANCELLED) != 'true'\n" +
            "   AND FULLY_PAID_DATE is null\n" +
            "   AND EXISTS(SELECT * FROM CW_BRANCH_INFORMATION B,M_ACCOUNTING_CHARGES C WHERE B.company_branch_code=C.branch_code AND B.company_code='SHA' AND A.TRA_ID=C.tra_id) and (A.COMPLIANCE_NUMBER like '%${param}%' or A.DATASOURCE_TYPE like  '%${param}%' or A.JOBINVOICENUMBER like  '%${param}%'  or A.ACCOUNT_CODE like  '%${param}%' or A.ACCOUNT_COMPANYNAME like  '%${param}%')" )
    List<fapiaoTable> findPrarmForTableCount(String param);

    /**
     * 调用存储过程，获取PoNo
     *
     */
    @Select({ "call SP_GET_AUTO_NO(#{P_ROLE_NAME,mode=IN,jdbcType=VARCHAR},#{P_RET,mode=OUT,jdbcType=VARCHAR})" })
    @Options(statementType= StatementType.CALLABLE)
    void getPoNo(Map<String,String> params);

    @Select("update M_ACCOUNTING_TRANSACTION set WEB_BANK=${status} where tra_id=${parseInt} ")
    Integer updateWebBankStatus(int parseInt,String status);



}
