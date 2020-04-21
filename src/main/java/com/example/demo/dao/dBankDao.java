package com.example.demo.dao;


import com.example.demo.entity.dBank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @Auther: DELL
 * @Date: 2019/12/19 14:10
 * @Description:
 */
public interface dBankDao extends JpaRepository<dBank,String> {

    @Query(nativeQuery = true,value = "select *  from dewell_edi.BD_BANK  where P_BANKNO is null ")
    List<dBank> getdBank();
}
