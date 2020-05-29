import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.DemoApplication;
import com.example.demo.dao.*;
import com.example.demo.entity.*;
import com.example.demo.mapper.ArApMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.mapper.fapiaoMapper;
import com.example.demo.mapper.mySelfMapper;
import com.example.demo.service.paymentService;
import com.github.wenhao.jpa.Specifications;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.*;

/**
 * @Auther: DELL
 * @Date: 2019/10/12 14:09
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class myjpatest {
    @Autowired
    private paymentService paymentServiceIImp;
    @Autowired
    private customerAccountDao customerAccountDao;
    @Autowired
    private AccountDao AccountDao;
    @Autowired
    private dBankInfoDao dBankInfoDao;
    @Autowired
    private paymentDao paymentDao;
    @Autowired
    private dBankDao dBankDao;
    @Autowired
    private traDao traDao;
    @Autowired
    private UserMapper UserMapper;
    @Autowired
    private ArApMapper ArApMapper;
    @Autowired
    private AccountingTransactionDao AccountingTransactionDao;
    @Autowired
    private  CompanyProfileDao CompanyProfileDao;
    @Test
    public  void  mytest(){
       // List<BankAccount> account=paymentServiceIImp.getAllBankAccount("USD");
        /*String compycode=paymentServiceIImp.getsubCompycode("SA");
        List<company> list=paymentServiceIImp.getAll(compycode);*/
        //List<fapiaoTable> list=paymentServiceIImp.getAllfapiaoTable();
        //System.out.println(list.toString());
        /*List<Account> list=AccountDao.getbyNameandtype("招商银行","RMB");
        System.out.println(list);*/
       /* String a =paymentServiceIImp.getPoNo("Pay_Code");
        System.out.println(a);*/

        /*dBankinfo dBankinfo=dBankInfoDao.getOne("CBM");
        System.out.println(dBankinfo);*/
        //Pageable pageable=new PageRequest(1,100);
      /*  List<fapiaoTable> list= paymentServiceIImp.findPrarmForTableCount("LIANDONG_SHA");


        System.out.println(list);*/
    /*  CustomerAccount a =customerAccountDao.getOne(4435855);
        a.setCustomerId("4435855");
        a.setBActive("1");
        a.setCustomerId("LIANDONG_SHA");
        a.setCurrType("RMB");
        a.setBankName("asdwssdwd");
        a.setAccountName("1");
        a.setAccountNumber("1");
        a.setCreateBy("SA");
        a.setCreateDate(new Date());
        a.setCityName("上海");
        a.setProvinceName("上海市");
        a.setCountryCode("黄浦区");
        customerAccountDao.save(a);*/
      /*  Pageable pageable=PageRequest.of(0,50);
        Page<Payment> Page= paymentDao.findAll(pageable);
        System.out.println(Page.getTotalElements());*/
       // System.out.println( customerAccountDao.getcustomerforcustomerID("00001"));
       // paymentServiceIImp.updateWebBankStatus(452067,"2");

      /*  System.out.println("___________________________");
        //traDao.findAll().forEach(System.out::println);
        Pageable pageable= PageRequest.of(0,3);
        Specification<Payment> specification=Specifications.<Payment>and().
                between(1!=1,"checkindate", null, null)
                .like("payAccount","%12590435%")
                .build();
       paymentDao.findAll(specification,pageable).forEach(System.out::println);*/
     /*  String a=",DWEC,DWHC,DWFC,DWSC,DWUC,DWBGD,DWTH,DWSG,DWKR,SUBAGENT,SUNM,JASINDO,ROSEMOUNT,PRICARGO,THORESEN,ZIEGLER FRANCE,SWIFT FREIGHT,IN_CREST,AGAPE,WICE,TWGM,ALLSYS,WINPLUS,UNION CHAMPION,JEMARA,DWVN,DWDC,DEWELL,EAST CHINA,DWKN,DWXM,DWFZ,DWSH,DWNB,DWDM,DWJX,DWHZ,00412,DWXS,DWSN,SOUTH CHN,DWGZ,DWSZ,DWHK,DWZS,DWNN,DWSA,DWZN,DWID,NORTH CHINA,DWJSU,DWNJ,DWNT,DWHF,DWDL,DWQD,DWWH,DWCQ,DWTJ,DWBN,DE WELL(USA),01585,00083,00066,00002,00001,00070,00071,00096,DWCHQ,DWMY,DWIN";
        System.out.println(ArApMapper.getCompanyCode(a));*/
        //System.out.println(DateUtil.parse("2020-01-26 14:25:00","yyyy-MM-dd hh:mm:ss")
        List<String> a =new ArrayList<>();
        a.add("111111");
        a.add("222222");
        System.out.println( ArApMapper.getEntityByTraids(a));
    }
}
