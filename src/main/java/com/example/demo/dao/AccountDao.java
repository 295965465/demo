package com.example.demo.dao;

import com.example.demo.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: DELL
 * @Date: 2019/12/19 10:41
 * @Description:
 */
@Repository
public interface AccountDao extends JpaRepository<Account,String> {
    @Query(nativeQuery = true,value = "select * from d_account a where a.account_set in (select ACCOUNT_INFO from COMPANY_PROFILE connect by prior COMPANY_CODE = PARENT_COMPANY_CODE start with COMPANY_CODE =?1) ")
    List<Account> getbyNameandtype(String officeCode);
    @Query(nativeQuery = true,value = "select * from D_ACCOUNT where  account_number=?1")
    Account getcityAndName(String accoun);
    @Query(nativeQuery = true,value = "select * from d_account a where a.BANK_NAME=?1 ")
    List<Account> getbyName(String bankName);


}
