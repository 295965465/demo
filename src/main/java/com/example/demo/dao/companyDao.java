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
public interface companyDao extends JpaRepository<company,String> {

    @Query(nativeQuery = true,value = "SELECT FUN_GET_SUBCOMPANY(p_user.Company_code) AS sub_company" +
            "      FROM p_user,company_profile" +
            "     WHERE p_user.b_enabled = 1" +
            "       AND p_user.company_code = company_profile.company_code" +
            "       AND p_user.user_code =?1")

    String getsubCompycode(String userCode);
    @Query(nativeQuery = true,value = "SELECT a.company_code as company_code ,b.company_name as company_name FROM company_profile_options a,company_profile b  where a.b_account=1 and a.company_code=b.company_code AND INSTR(?1,a.Company_code) > 0 order by company_code")
    List<company> getAll(String Sub_Company_code);

}
