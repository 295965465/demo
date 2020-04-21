package com.example.demo.dao;

import com.example.demo.entity.dBankinfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Auther: DELL
 * @Date: 2019/12/19 14:10
 * @Description:
 */
public interface dBankInfoDao  extends JpaRepository<dBankinfo,String> {
}
