package com.example.demo.dao;

import com.example.demo.entity.AccountingTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

/**
 * @Auther: DELL
 * @Date: 2020/1/15 10:06
 * @Description:
 */
public interface AccountingTransactionDao extends JpaRepository<AccountingTransaction,String> {

    @Query(nativeQuery = true,value = "select  * from  M_ACCOUNTING_TRANSACTION where TRA_ID in (:tarids)")

    List<AccountingTransaction> getAllByTraId(@Param("tarids")Set traids);


}
