package com.example.demo.dao;

import com.example.demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Auther: DELL
 * @Date: 2019/10/12 13:37
 * @Description:
 */
@Repository
public interface paymentDao extends JpaRepository<Payment,String> {
 @Query(nativeQuery = true,value = "select sysdate from dual")
    String getsystemDate();
}
