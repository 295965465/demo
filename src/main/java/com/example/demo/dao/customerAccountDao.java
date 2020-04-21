package com.example.demo.dao;

import com.example.demo.entity.CustomerAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: DELL
 * @Date: 2019/10/24 18:34
 * @Description:
 */
@Repository
public interface customerAccountDao extends JpaRepository<CustomerAccount,Integer>, JpaSpecificationExecutor {
    @Query(nativeQuery = true,value = "select count(*) from dewell_edi.C_CUSTOMER_ACCOUNT where CUSTOMER_ID=?1 and CURR_TYPE=?2 and ACCOUNT_NUMBER=?3")
    int getcustomercountforcustomerID(String customerId,String currType,String accountnumber);
    @Query(nativeQuery = true,value = "select * from dewell_edi.C_CUSTOMER_ACCOUNT where CUSTOMER_ID=?1 and CURR_TYPE=?2 and ACCOUNT_NUMBER=?3")
    CustomerAccount getcustomerforcustomerID(String customerId,String currType,String accountnumber);
    @Query(nativeQuery = true,value = "select * from dewell_edi.C_CUSTOMER_ACCOUNT where CUSTOMER_ID=?1 and CURR_TYPE=?2 and   rownum=1")
    CustomerAccount getcustomerforcustomerIDS(String customerId,String currType);
    @Modifying
    @Transactional
    @Query(nativeQuery = true,value = "update C_CUSTOMER_ACCOUNT set BANK_NAME=:#{#customerAccount.bankName},ACCOUNT_NAME=:#{#customerAccount.accountName}," +
            "ACCOUNT_NUMBER=:#{#customerAccount.accountNumber},COUNTRY_CODE=:#{#customerAccount.countryCode},PROVINCE_NAME=:#{#customerAccount.provinceName},CITY_NAME=:#{#customerAccount.cityName} where CUSTOMER_ID=:#{#customerAccount.customerId} and ACCOUNT_NUMBER=:#{#customerAccount.accountNumber}")
    void updateCustomer(@Param("customerAccount") CustomerAccount customerAccount);
}
