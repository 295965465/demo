package com.example.demo.service;

import com.example.demo.entity.BankAccount;
import com.example.demo.entity.company;
import com.example.demo.entity.fapiaoTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/**
 * @Auther: DELL
 * @Date: 2019/10/12 13:58
 * @Description:
 */
public interface paymentService {
    String testDate();
    List<BankAccount> getAllBankAccount(String currency_code);
    String getsubCompycode(String userCode);
    List<company> getAll(String Sub_Company_code);
    List<fapiaoTable> getAllfapiaoTable();
    Page<fapiaoTable> findAllTable(Pageable pageable);
    List<fapiaoTable> findPrarmForTable(String param,Integer fromIndex,Integer toIndex);

    List<fapiaoTable> findPrarmForTableCount(String param);
    String getPoNo(String params);

    Integer updateWebBankStatus(int parseInt,String status);



}
