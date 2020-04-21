package com.example.demo.dao;

import com.example.demo.entity.AccountingCharges;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: DELL
 * @Date: 2020/4/15 12:58
 * @Description:
 */
public interface AccountingChargesDao  extends JpaRepository<AccountingCharges,String> {

    @Query(nativeQuery = true,value ="SELECT * FROM M_ACCOUNTING_CHARGES WHERE TRA_ID=?1")
    List<AccountingCharges>  findbyTraid(String TraId);


}
