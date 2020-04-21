package com.example.demo.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Map;


/**
 * @Auther: DELL
 * @Date: 2019/12/27 17:56
 * @Description:
 */
@Mapper
public interface UserMapper extends BaseMapper<User>  {

    @Select("select a.USER_ID,a.USER_NAME,a.PASSWORD,a.COMPANY_ID,a.EMAIL,a.CARGO_USER_CODE cargoUserCode,(select wm_concat(b.ROLE_ID)  from dewell_web.P_ROLE2USER b where b.user_id = a.user_id) as role_ids," +
            " (select c.COMPANY_CODE  from dewell_web.P_COMPANY c where c.COMPANY_ID = a.COMPANY_ID)as title" +
            "  from dewell_web.P_USER a" +
            "  where active = 1 and (USER_CODE=#{name}" +
            "  OR a.USER_NAME=#{name}" +
            "  or a.EMAIL=#{name})")
    public Map<String,Object> getUserByName(String name);
    @Select("select * from M_tra")
     List<Map<String,Object>> getalltra();
}
