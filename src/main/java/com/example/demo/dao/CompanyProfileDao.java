package com.example.demo.dao;

import com.example.demo.entity.CompanyProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @Auther: DELL
 * @Date: 2020/1/15 16:39
 * @Description:
 */
@Repository
public interface CompanyProfileDao extends JpaRepository<CompanyProfile,String> {
    @Query(nativeQuery = true,value = "select * from dewell_edi.COMPANY_PROFILE where COMPANY_CODE=?1 ")
    CompanyProfile getByCompanyCode(String companyCode);
}
