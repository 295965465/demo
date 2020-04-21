package com.example.demo.dao;

import com.example.demo.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * @Auther: DELL
 * @Date: 2019/10/12 13:37
 * @Description:
 */
@Repository
public interface paymentDao extends JpaRepository<Payment,Integer>,JpaSpecificationExecutor{
 @Query(nativeQuery = true,value = "select sysdate from dual")
    String getsystemDate();

 @Query(nativeQuery = true, value = "select * from DEWELL_EDI.M_PAYMENT where  CHECKINDATE between to_date(?1,'yyyy-MM-dd hh24:mi:ss') and to_date(?2,'yyyy-MM-dd hh24:mi:ss') and (INVOICE_INFO like %?3% or PAY_ACCOUNT like %?3% )")
 List<Payment> getPaymentByCheckindateAndLikesomeParam( @Param("fromDate")String fromDate, @Param("toDate")String toDate,@Param("param")String param );

 @Query(nativeQuery = true, value = "select * from DEWELL_EDI.M_PAYMENT where  CHECKINDATE between to_date(?1,'yyyy-MM-dd') and to_date(?2,'yyyy-MM-dd')")
    List<Payment> getPaymentByCheckindate (@Param("fromDate")String fromDate, @Param("toDate")String toDate);



    @Query(nativeQuery = true, value = "select * from DEWELL_EDI.M_PAYMENT where (INVOICE_INFO like %?1% or PAY_ACCOUNT like %?1% )")
    List<Payment> getPaymentLikesomeParam(@Param("param")String param );

    @Query(nativeQuery = true, value = "select * from DEWELL_EDI.M_PAYMENT where PAYMENT_ID=?1")

    Payment getPaymentByPamentId(Integer paymentid);

}
