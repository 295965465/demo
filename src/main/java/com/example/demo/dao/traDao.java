package com.example.demo.dao;

import com.example.demo.entity.Tra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: DELL
 * @Date: 2019/10/12 13:37
 * @Description:
 */
@Repository
public interface traDao extends JpaRepository<Tra,String>{
    @Query(nativeQuery = true,value = "select * from DEWELL_EDI.M_TRA")
    List<Tra> getAllBy();

}
