package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.entity.ArApEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Auther: DELL
 * @Date: 2020/4/10 10:13
 * @Description:
 */
@Mapper
public interface ArApMapper extends BaseMapper<ArApEntity> {

    IPage<ArApEntity> getAllArAp(Page<ArApEntity> page,String ledger,List<String> branchCode,Date postDate,Date postEndDate,Date transactiondate,Date transactionEnddate,String accountCode,String seachstatus);

    @Select("select a.COMPANY_BRANCH_CODE\n" +
            "  from CW_BRANCH_INFORMATION a,CW_CARGO6_MAPPING b\n" +
            " where b.CW=a.ORGANIZATION_CODE\n" +
            "   and b.type='OFFICE'\n" +
            "   and instr(#{subCompangy},b.CARGO6) > 0")
    List<String> getCompanyCode(String subCompangy);

}
