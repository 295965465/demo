package com.example.demo.dao;

import com.example.demo.entity.ebbanklog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Auther: DELL
 * @Date: 2020/3/26 11:03
 * @Description:
 */
@Repository
public interface WebBankLogDao extends JpaRepository<ebbanklog, Integer> {
}
