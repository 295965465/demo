package com.example.demo.dao;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: DELL
 * @Date: 2019/10/21 13:53
 * @Description:
 */
@Repository
public interface bankAccountDao extends JpaRepository<BankAccount,String> {
    @Query(nativeQuery = true,value = "select currency_code, currency_name,edi_code,edi_code2 from d_currency where  b_enable=1 and currency_code=?1 order by currency_name desc")
    List<BankAccount> getAllBankAccount(String currency_code);

}
