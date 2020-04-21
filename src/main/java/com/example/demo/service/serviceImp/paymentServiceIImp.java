package com.example.demo.service.serviceImp;

import com.example.demo.dao.*;
import com.example.demo.entity.BankAccount;
import com.example.demo.entity.company;
import com.example.demo.entity.fapiaoTable;
import com.example.demo.mapper.mySelfMapper;
import com.example.demo.service.paymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: DELL
 * @Date: 2019/10/12 14:00
 * @Description:
 */
@Service
public class paymentServiceIImp implements paymentService {
   @Autowired
    private  paymentDao paymentDao;
    @Autowired
    private bankAccountDao bankAccountDao;
    @Autowired
    private companyDao companyDao;
    @Autowired
    private faPiaoTableDao faPiaoTableDao;
    @Autowired
    private mySelfMapper fapiaoMapper;
    @Override
    public String testDate() {

        return paymentDao.getsystemDate();
    }

    @Override
    public List<BankAccount> getAllBankAccount(String currency_code) {
        return bankAccountDao.getAllBankAccount(currency_code);
    }

    @Override
    public String getsubCompycode(String userCode) {
        return companyDao.getsubCompycode(userCode);
    }

    @Override
    public List<company> getAll(String Sub_Company_code) {
        return companyDao.getAll(Sub_Company_code);
    }

    @Override
    public List<fapiaoTable> getAllfapiaoTable() {
        return fapiaoMapper.getAllfapiaoTable();
    }

    @Override
    public Page<fapiaoTable> findAllTable(Pageable pageable) {
        return  faPiaoTableDao.findAllTable(pageable);
    }

    @Override
    public List<fapiaoTable> findPrarmForTable(String param, Integer fromIndex,Integer toIndex) {
        return faPiaoTableDao.findPrarmForTable(param,fromIndex,toIndex);
    }

    @Override
    public List<fapiaoTable> findPrarmForTableCount(String param) {
        return faPiaoTableDao.findPrarmForTableCount(param);
    }

    @Override
    public String getPoNo(String P_ROLE_NAME) {
        Map<String,String> params=new HashMap<>();
        params.put("P_ROLE_NAME", P_ROLE_NAME);
        fapiaoMapper.getPoNo(params);
        String PoNo=params.get("P_RET");
        return PoNo;

    }

    @Override
    public Integer updateWebBankStatus(int parseInt,String status) {
       return fapiaoMapper.updateWebBankStatus(parseInt,status);
    }

}
