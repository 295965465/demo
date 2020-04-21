package com.example.demo.dao;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.fapiaoTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: DELL
 * @Date: 2019/10/21 13:53
 * @Description:
 */
@Repository
public interface faPiaoTableDao extends JpaRepository<fapiaoTable,Integer>{
    @Query(nativeQuery = true,value = "select DATASOURCE_TYPE,COMPLIANCE_NUMBER,JOBINVOICENUMBER,ACCOUNT_CODE,ACCOUNT_COMPANYNAME,DUEDATE,POSTDATE,-OS_TOTAL AS OS_TOTAL,LOCAL_CURRENCY,TRA_ID\n" +
            "  from dewell_edi.M_ACCOUNTING_TRANSACTION" +
            " where DATASOURCE_TYPE like 'AP INV%'" +
            "   AND (WEB_BANK='N' OR WEB_BANK IS NULL)" +
            "   AND lower(IS_CANCELLED) != 'true'")
    List<fapiaoTable> getAllfapiaoTable();

    @Query(nativeQuery = true,value = "select A.DATASOURCE_TYPE,A.COMPLIANCE_NUMBER,A.JOBINVOICENUMBER,A.ACCOUNT_CODE,A.ACCOUNT_COMPANYNAME,DUEDATE,A.POSTDATE,\n" +
            "       -A.OUTSTANDING_AMOUNT AS OUTSTANDING_AMOUNT,-A.OS_TOTAL AS OS_TOTAL,A.OS_CURRENCY,-A.LOCAL_TOTAL AS LOCAL_TOTAL,A.LOCAL_CURRENCY,A.TRA_ID\n" +
            "  from M_ACCOUNTING_TRANSACTION A\n" +
            " where A.DATASOURCE_TYPE like 'AP INV%'\n" +
            "   AND (WEB_BANK='N' OR WEB_BANK IS NULL)\n" +
            "   AND lower(IS_CANCELLED) != 'true'\n" +
            "   AND FULLY_PAID_DATE is null\n" +
            "   AND EXISTS(SELECT * FROM CW_BRANCH_INFORMATION B,M_ACCOUNTING_CHARGES C WHERE B.company_branch_code=C.branch_code AND B.company_code='SHA' AND A.TRA_ID=C.tra_id)\n",countQuery ="select A.DATASOURCE_TYPE,A.COMPLIANCE_NUMBER,A.JOBINVOICENUMBER,A.ACCOUNT_CODE,A.ACCOUNT_COMPANYNAME,DUEDATE,A.POSTDATE,\n" +
            "       -A.OUTSTANDING_AMOUNT AS OUTSTANDING_AMOUNT,-A.OS_TOTAL AS OS_TOTAL,A.OS_CURRENCY,-A.LOCAL_TOTAL AS LOCAL_TOTAL,A.LOCAL_CURRENCY,A.TRA_ID\n" +
            "  from M_ACCOUNTING_TRANSACTION A\n" +
            " where A.DATASOURCE_TYPE like 'AP INV%'\n" +
            "   AND (WEB_BANK='N' OR WEB_BANK IS NULL)\n" +
            "   AND lower(IS_CANCELLED) != 'true'\n" +
            "   AND FULLY_PAID_DATE is null\n" +
            "   AND EXISTS(SELECT * FROM CW_BRANCH_INFORMATION B,M_ACCOUNTING_CHARGES C WHERE B.company_branch_code=C.branch_code AND B.company_code='SHA' AND A.TRA_ID=C.tra_id)\n")
    Page<fapiaoTable> findAllTable(Pageable pageable);
    @Query(nativeQuery = true,value = "select * from ( select row_.*, rownum rownum_ from (select A.DATASOURCE_TYPE,A.COMPLIANCE_NUMBER,A.JOBINVOICENUMBER,A.ACCOUNT_CODE,A.ACCOUNT_COMPANYNAME,DUEDATE,A.POSTDATE,\n" +
            "       -A.OUTSTANDING_AMOUNT AS OUTSTANDING_AMOUNT,-A.OS_TOTAL AS OS_TOTAL,A.OS_CURRENCY,-A.LOCAL_TOTAL AS LOCAL_TOTAL,A.LOCAL_CURRENCY,A.TRA_ID\n" +
            "  from M_ACCOUNTING_TRANSACTION A\n" +
            " where A.DATASOURCE_TYPE like 'AP INV%'\n" +
            "   AND (WEB_BANK='N' OR WEB_BANK IS NULL)\n" +
            "   AND lower(IS_CANCELLED) != 'true'\n" +
            "   AND FULLY_PAID_DATE is null\n" +
            "   AND EXISTS(SELECT * FROM CW_BRANCH_INFORMATION B,M_ACCOUNTING_CHARGES C WHERE B.company_branch_code=C.branch_code AND B.company_code='SHA' AND A.TRA_ID=C.tra_id) and (COMPLIANCE_NUMBER like %?1% or DATASOURCE_TYPE like %?1% or JOBINVOICENUMBER like %?1%  or ACCOUNT_CODE like %?1% or ACCOUNT_COMPANYNAME like %?1% )) row_ where rownum <=?3) where rownum_ >?2")
    List<fapiaoTable> findPrarmForTable(String param,Integer fromIndex,Integer toIndex);
    @Query(nativeQuery = true,value = "select A.DATASOURCE_TYPE,A.COMPLIANCE_NUMBER,A.JOBINVOICENUMBER,A.ACCOUNT_CODE,A.ACCOUNT_COMPANYNAME,DUEDATE,A.POSTDATE,\n" +
            "       -A.OUTSTANDING_AMOUNT AS OUTSTANDING_AMOUNT,-A.OS_TOTAL AS OS_TOTAL,A.OS_CURRENCY,-A.LOCAL_TOTAL AS LOCAL_TOTAL,A.LOCAL_CURRENCY,A.TRA_ID\n,null as rownum_" +
            "  from M_ACCOUNTING_TRANSACTION A\n" +
            " where A.DATASOURCE_TYPE like 'AP INV%'\n" +
            "   AND (WEB_BANK='N' OR WEB_BANK IS NULL)\n" +
            "   AND lower(IS_CANCELLED) != 'true'\n" +
            "   AND FULLY_PAID_DATE is null\n" +
            "   AND EXISTS(SELECT * FROM CW_BRANCH_INFORMATION B,M_ACCOUNTING_CHARGES C WHERE B.company_branch_code=C.branch_code AND B.company_code='SHA' AND A.TRA_ID=C.tra_id) and (COMPLIANCE_NUMBER like %?1% or DATASOURCE_TYPE like %?1% or JOBINVOICENUMBER like %?1%  or ACCOUNT_CODE like %?1% or ACCOUNT_COMPANYNAME like %?1% )" )
    List<fapiaoTable> findPrarmForTableCount(String param);
}
