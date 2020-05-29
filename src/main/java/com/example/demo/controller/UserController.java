package com.example.demo.controller;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HtmlUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.example.demo.aspect.Log;
import com.example.demo.dao.*;
import com.example.demo.entity.*;
import com.example.demo.mapper.ArApMapper;
import com.example.demo.service.paymentService;
import com.github.wenhao.jpa.Sorts;
import com.github.wenhao.jpa.Specifications;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

/**
* Created by CodeGenerator on 2019/05/16.
*/
@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private paymentService paymentServiceIImp;
    @Autowired
    private AccountDao AccountDao;
    @Autowired
    private customerAccountDao customerAccountDao;
    @Autowired
    private dBankInfoDao dBankInfoDao;
    @Autowired
    private paymentDao  paymentDao;
    @Autowired
    private traDao  traDao;
    @Autowired
    private dBankDao  dBankDao;
    @Autowired
    private AccountingTransactionDao AccountingTransactionDao;
    @Autowired
    private  CompanyProfileDao CompanyProfileDao;
    @Autowired
    private  traMatchDao traMatchDao;
    @Resource
    private ArApMapper arApMapper;
    @RequestMapping(value = "/hello")
    public String show(Model model,String name, HttpSession session,String modeType) {

        if (StrUtil.isBlank(name)){
            return "login";
        }else{
            String poNo=paymentServiceIImp.getPoNo("Pay_Code");
            model.addAttribute("name", "Dear");
            model.addAttribute("yewu",poNo);
            model.addAttribute("CWusercode",name);
            model.addAttribute("modeType",modeType);
            session.setAttribute("userCode",name);
            return "hello";
        }

    }
    @RequestMapping(value = "/edit")
    @Log("编辑")
    public String edit(Model model,String name,Integer paymentid) {

        System.out.println(paymentid);

            Payment payment=paymentDao.getPaymentByPamentId(paymentid);
            model.addAttribute("yewu",payment.getPNo());
            model.addAttribute("paymentID",paymentid);
            model.addAttribute("payment",payment);
            model.addAttribute("CWusercode",name);
            model.addAttribute("customerAccountID",payment.getCaccountid());
            if (StrUtil.isNotBlank(payment.getInvoiceInfoid())) {
                for (String s : payment.getInvoiceInfoid().split(";")) {
                    paymentServiceIImp.updateWebBankStatus(Integer.parseInt(s), "''");

                }
            }
            return "edit";


    }
    @RequestMapping(value = "/trading")
    public String tradingShow() {

        return "trading";


    }


    @RequestMapping(value = "/error")
    public String error() {

        return "error";
    }
    @RequestMapping(value = "/index")
    public String index() {

        return "index";
    }
    @RequestMapping(value = "/mytest",method = RequestMethod.POST)
    @ResponseBody
    @Transactional(rollbackFor = Exception.class)
    @Log("保存")
    public void test(@RequestParam Map<String,Object> news,HttpSession session){
        Payment payment =new Payment();
        CustomerAccount customerAccount=new CustomerAccount();
        String PoNo          = (String) news.get("title");
        String OP_STY        = (String) news.get("yewuleixing");
        String PAY_ACCOUNT   = (String) news.get("fufangzhanghao");
        String PAY_ACCNAME   = (String) news.get("zhanghaomingcheng");
        String Pertag        = (String) news.get("interest");
        String accountName   = (String) news.get("bank");
        String moneyname     = (String) news.get("moneyname");
        String op_brief      = (String) news.get("yewuzhaiyao");
        String tra_money     = (String) news.get("zhifunumber");
        String purpose       = (String) news.get("yunTu");
        String acc_id        = (String) news.get("paymentMethod");
        String acc_name      = acc_id.equals("N")?"普通":"快速";
        String CustoNameID     = (String) news.get("gukeID");
        String CustoName     = (String) news.get("gukeIDInput");
        String account_number= (String) news.get("shoufangzhanghao");
        String account_name  = (String) news.get("shoufangmingcheng");
        String rec_obankname = (String) news.get("kaihumingcheng");
        String rec_obankaddress  = (String) news.get("dizhi");
        String rec_county    = (String) news.get("xianqu");
        String rec_prov    = (String) news.get("shengfeng");
        String rec_city    = (String) news.get("city");
        String fapiao      = (String) news.get("faPiao");
        String USERCOMPANYS      = (String) news.get("USERCOMPANYS");
        String fapiaoID      = (String) news.get("faPiaoID");
        String kaihudif      = (String) news.get("kaihudif");
        String kaihudicode      = (String) news.get("kaihudicode");
        String paymentid        = (String) news.get("paymentid");
        String officeCode      = (String) news.get("officeCode");
        Date checkindate   = DateUtil.parseDateTime((String) news.get("date"));
        System.out.println("前台accountName的数据是："+accountName);
        String edicode;
        if (accountName.equals("CMB")){
            edicode=paymentServiceIImp.getAllBankAccount(moneyname).get(0).getEdiCode();
        }else{
            edicode=paymentServiceIImp.getAllBankAccount(moneyname).get(0).getEdiCode2();
        }
        dBankinfo dBankinfo=dBankInfoDao.getOne(edicode);
        System.out.println("前台的数据是："+news);
        if (!StrUtil.isBlank(paymentid)){
            payment.setPamentId(Integer.parseInt(paymentid));
        }
        if (!StrUtil.isBlank(CustoNameID)){
            customerAccount.setCustomerAccountId(Integer.parseInt(CustoNameID));

        }
        payment.setUsercompany("直接选择或搜索选择".equals(officeCode)?USERCOMPANYS:officeCode);
        payment.setPNo(PoNo);
        payment.setOpRefno(PoNo);
        payment.setOpSty(OP_STY);
        payment.setPayAccount(PAY_ACCOUNT);
        payment.setPayAccname(PAY_ACCNAME);
        payment.setBankId(accountName);
        payment.setPertag(Pertag);
        payment.setMonType(moneyname);
        payment.setMonTypeis(edicode);
        payment.setOpBrief(op_brief);
        payment.setTraMoney(tra_money);
        payment.setPurpose(purpose);
        payment.setAccId(acc_id);
        payment.setAccName(acc_name);
        payment.setCustoname(CustoName);
        payment.setPayBankareaname(kaihudif);
        payment.setPayBankareaid(kaihudicode);
        customerAccount.setCustomerId(CustoName);
        customerAccount.setBActive("1");
        payment.setRecAccounts(account_number);
        customerAccount.setAccountNumber(account_number);
        payment.setRecName(account_name);
        customerAccount.setAccountName(account_name);
        payment.setRecObankname(rec_obankname);
        customerAccount.setBankName(rec_obankname);
        payment.setRecObankaddress(rec_obankaddress);
        //customerAccount现在少地址
        payment.setDCheckmark("0");
        payment.setRecCity(rec_city);
        customerAccount.setCityName(rec_city);
        payment.setRecCounty(rec_county);
        customerAccount.setCountryCode(rec_county);
        payment.setRecProv(rec_prov);
        customerAccount.setProvinceName(rec_prov);
        payment.setCheckindate(checkindate);
        customerAccount.setCurrType(moneyname);
        customerAccount.setCreateDate(new Date());
        customerAccount.setCreateBy(session.getAttribute("userCode").toString());
        if (!StrUtil.isBlank(fapiao)){
            payment.setInvoiceInfo(fapiao.replace(";","\r\n"));
            payment.setInvoiceInfoid(fapiaoID);
            for (String s : fapiaoID.split(";")) {
                paymentServiceIImp.updateWebBankStatus(Integer.parseInt(s),"1");
            }
        }

        customerAccount=customerAccountDao.saveAndFlush(customerAccount);
        payment.setCaccountid(customerAccount.getCustomerAccountId());
        paymentDao.save(payment);


    }
    @RequestMapping(value = "/initSelect",method = RequestMethod.POST)
    @ResponseBody
    public List<Account> getAccount(String OfficeCode){
        System.out.println("OfficeCode:"+OfficeCode);
        return AccountDao.getbyNameandtype(OfficeCode);
    }

    @RequestMapping(value = "/initSelect_cityAndName",method = RequestMethod.POST)
    @ResponseBody
    public Account test(String Accoun){

        return AccountDao.getcityAndName(Accoun);
    }

    @RequestMapping(value = "/initSelect_gukeID",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> initSelect_gukeID(@Param(value = "param") String param,@Param(value = "param1") String param1, @Param(value = "page") int page, @Param(value = "limit")int limit){
        Map<String,Object> map=new HashMap<>();
        Specification<CustomerAccount> specification= Specifications.<CustomerAccount>and()
                .eq(StrUtil.isNotBlank(param),"customerId",param)
                .like(StrUtil.isNotBlank(param1),"accountName","%"+param1+"%")
                .build();
        List<CustomerAccount> list1 = customerAccountDao.findAll(specification);
        map.put("data",list1);
        map.put("code",0);
        map.put("msg","");
        map.put("count",list1.size());
        return map;
    }

    @RequestMapping(value = "/initSelect_guke",method = RequestMethod.POST)
    @ResponseBody
    public CustomerAccount test_initSelect_guke(String accountCode,String moneyname){

        return customerAccountDao.getcustomerforcustomerIDS(accountCode,moneyname);
    }
    @RequestMapping(value = "/initSelect_office",method = RequestMethod.POST)
    @ResponseBody
    public List<company> initSelect_office(String usercode){
        String compycode=paymentServiceIImp.getsubCompycode(usercode);
        List<company> list=paymentServiceIImp.getAll(compycode);
        return list;
    }
    @RequestMapping(value = "/initfapiaoTable",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> initfapiaoTable(@Param(value = "param") String param, @Param(value = "page") int page, @Param(value = "limit")int limit){
        System.out.println("查询条件是："+param);
        Map<String,Object> map=new HashMap<>();
        //List<fapiaoTable> list=paymentServiceIImp.getAllfapiaoTable();
        Pageable pageable=new PageRequest(page,limit);

        if (StrUtil.hasBlank(param)){
           // Page<fapiaoTable> list= paymentServiceIImp.findAllTable(pageable);
            map.put("data",null);
            map.put("code",0);
            map.put("msg","");
            map.put("count",0);
        }else{
            int pageNumber = page - 1;
            int fromIndex = pageNumber * limit;
            int toIndex = pageNumber * limit + limit;
            List<fapiaoTable> list1= paymentServiceIImp.findPrarmForTableCount(param);
         // List<fapiaoTable> list= paymentServiceIImp.findPrarmForTable(param,fromIndex,toIndex);
            map.put("data",list1);
            map.put("code",0);
            map.put("msg","");
            map.put("count",list1.size());
        }

        return map;
    }



    @RequestMapping(value = "/initMyPamentTable",method = RequestMethod.POST)
    @ResponseBody
    @Log("主页查数据")
    public Map<String,Object> initMyPamentTable(@Param(value = "param") String param,
                                                @Param(value = "seachfapiao") String seachfapiao,
                                                @Param(value = "seachstatus") String seachstatus,
                                                @Param(value = "seachoffice") String seachoffice,
                                                @Param(value = "seachpono") String seachpono,
                                                @Param(value = "daterange") String daterange, @Param(value = "page") int page, @Param(value = "limit")int limit){
        log.info("payAccount{},checkindate{},invoiceInfo{},usercompany{},pNo{},seachstatus{}",param,daterange,seachfapiao,seachoffice,seachpono,seachstatus);
        Map<String,Object> map=new HashMap<>();
        int pageNumber = page - 1;
        Date fromdate=null;
        Date todate=null;
        if(StrUtil.isNotBlank(daterange)){
            fromdate=DateUtil.parse(daterange.split(" - ")[0],"yyyy-MM-dd hh:mm:ss");
            todate=DateUtil.parse(daterange.split(" - ")[1],"yyyy-MM-dd hh:mm:ss");

        }
        Sort sort =Sorts.builder()
                .desc("checkindate")
                .build();
        Pageable pageable= PageRequest.of(pageNumber,limit,sort);
        Specification<Payment> specification= Specifications.<Payment>and()
                .between(StrUtil.isNotBlank(daterange),"checkindate",fromdate,todate)
                .like(StrUtil.isNotBlank(param),"payAccount","%"+param+"%")
                .like(StrUtil.isNotBlank(seachfapiao),"invoiceInfo","%"+seachfapiao+"%")
                .eq(StrUtil.isNotBlank(seachstatus),"dCheckmark",seachstatus)
                .like(StrUtil.isNotBlank(seachoffice),"usercompany","%"+seachoffice+"%")
                .like(StrUtil.isNotBlank(seachpono),"pNo","%"+seachpono+"%")
                .build();
        Page<Payment> Page =paymentDao.findAll(specification,pageable);
        map.put("data",Page.getContent());
        map.put("code",0);
        map.put("msg","");
        map.put("count",Page.getTotalElements());


        return map;
    }

    @RequestMapping(value = "/initMytraingTable",method = RequestMethod.POST)
    @ResponseBody
    @Log("查记录")
    public Map<String,Object> initMytraingTable(@Param(value = "param") String param,@Param(value = "daterange") String daterange,@Param(value = "Ttype") String Ttype,@Param(value = "tranBankAccount") String tranBankAccount, @Param(value = "page") int page, @Param(value = "limit")int limit){
        Map<String,Object> map=new HashMap<>();
        map.clear();
        int pageNumber = page - 1;
        Pageable pageable= PageRequest.of(pageNumber,limit);

        if (StrUtil.hasBlank(param)&&StrUtil.hasBlank(daterange)){
            map.put("data",null);
            map.put("code",0);
            map.put("msg","");
            map.put("count",0);
        }else{
            String url="http://192.168.1.19:8000/efra2e34-tg567hvde-45rfbgt6-pp0fr933cd-3e5t87?bd="+param+"&zh="+tranBankAccount.split(":")[0]+"&srq="+daterange.split(" - ")[0].replace("-","")+"&erq="+daterange.split(" - ")[1].replace("-","")+"&dc="+Ttype+"&khh="+tranBankAccount.split(":")[1];
            System.out.println(url);
            String rest= HttpUtil.get(url);
            if (rest.indexOf("success")>-1){
                Page<Tra> Page1= traDao.findAll(pageable);
                //List<Tra> Page= traDao.findAll();
                map.put("data",Page1.getContent());
                map.put("code",0);
                map.put("msg","Success");
                map.put("count",Page1.getTotalElements());
            }else {
                map.put("data",null);
                map.put("code",0);
                map.put("msg",StrUtil.isBlank(rest)?"java.net.ConnectException: Connection refused: connect":rest);
                map.put("count",0);
            }




        }

        return map;
    }

    @RequestMapping(value = "/initSelect_traBankName",method = RequestMethod.POST)
    @ResponseBody
    public List<dBank> initSelect_traBankName(){

        return dBankDao.getdBank();
    }
    @RequestMapping(value = "/initSelect_tranBankAccount",method = RequestMethod.POST)
    @ResponseBody
    public List<Account> initSelect_tranBankAccount(String trabankName){

        return AccountDao.getbyName(trabankName);
    }
    @RequestMapping("/kaipai")
    @ResponseBody
    @Log("开票")
    public  String toKaipiao(String paymentId) throws UnsupportedEncodingException {
        String rest="";
        if (paymentDao.getPaymentByPamentId(Integer.parseInt(paymentId)).getBankId()=="CBM"){
            String url="http://192.168.1.19:8000/ee0o833-wkmfk-23foi9-eikfm9-3kfm?pd="+paymentId;
            rest= HttpRequest.get(url).execute().charset("GBK").body();

        }else{
            String url="http://192.168.1.19:8000/ee0o833-wkmfk-23foi9-eikfm9-3kfm?pd="+paymentId;
            rest= HttpRequest.get(url).execute().charset("GBK").body();
        }
        log.info("rest->>>{}", rest);
        String encode =URLEncoder.encode(HtmlUtil.cleanHtmlTag(rest), "UTF-8");
        if (rest.toUpperCase().indexOf("SUCCESS")>-1){
            Payment payment=paymentDao.getPaymentByPamentId(Integer.parseInt(paymentId));
            if (StrUtil.isNotBlank(payment.getInvoiceInfoid())){
                for (String s : payment.getInvoiceInfoid().split(";")) {
                    paymentServiceIImp.updateWebBankStatus(Integer.parseInt(s),"2");

                }
            }
            return "SUCCESS";
        }else {
            return encode;
        }

    }
    @Log("核销")
    @RequestMapping("/DownLaod")
    public  void toDownLoad(HttpServletResponse response,String paymentid) throws  Exception{
        log.info("要下载的paymentid："+paymentid);
        String fileName ="Context_"+DateUtil.format(new Date(),"yyyyMMddHHmmss")+".csv";
        String realpath="C:\\wenbankLog\\"+fileName;
        CsvWriter writer = CsvUtil.getWriter(realpath, CharsetUtil.CHARSET_UTF_8);
        List a =new ArrayList();

        Payment Payment=paymentDao.getPaymentByPamentId(Integer.parseInt(paymentid));
        Account account=AccountDao.getcityAndName(Payment.getPayAccount());
        CompanyProfile  CompanyProfile=CompanyProfileDao.getByCompanyCode(Payment.getUsercompany());
        a.add(new String[]{"PAY", "AP", "PAY",DateUtil.format(Payment.getDCommit(),"yyyyMMdd"),DateUtil.format(Payment.getCheckindate(),"yyyyMMdd"),Payment.getCustoname(),"AP PAYMENT "+Payment.getRecName(),"DDR",account.getWebBankCode(),"",Payment.getPNo(),Payment.getMonType().equals("RMB")?"CNY":Payment.getMonType(),Payment.getTraMoney(),Payment.getTraMoney(),CompanyProfile.getBusinessSeal(),"FIN"});
        Set<String> strSet = new HashSet<>();
        CollectionUtils.addAll(strSet,Payment.getInvoiceInfoid().split(";"));
        List<AccountingTransaction> accountingTransactionList= AccountingTransactionDao.getAllByTraId(strSet);
        for (AccountingTransaction accountingTransaction : accountingTransactionList) {
            a.add(new String[]{"PTR", "AP", "INV",accountingTransaction.getJobinvoicenumber(),accountingTransaction.getOutstandingAmount(),Payment.getCustoname()});

        }
        writer.write(a);
        //按行写出
        writer.close();
        response.setHeader("content-disposition", "attachment;filename="+fileName);
        InputStream in = new FileInputStream(realpath);
             int len = 0;
               //5.创建数据缓冲区
                 byte[] buffer = new byte[1024];
                 //6.通过response对象获取OutputStream流
                OutputStream out = response.getOutputStream();
                //7.将FileInputStream流写入到buffer缓冲区
               while ((len = in.read(buffer)) > 0) {
                    //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
                       out.write(buffer,0,len);
                   }
               in.close();
        Payment.setDCheckmark("8");
        for (String s : Payment.getInvoiceInfoid().split(";")) {
            paymentServiceIImp.updateWebBankStatus(Integer.parseInt(s),"3");

        }
        paymentDao.save(Payment);
    }

    @Log("AR批量核销")
    @RequestMapping("/DownLaods")
    public  void toDownLoads(HttpServletResponse response,String data,String param) throws  Exception{

        String fileName ="Context_"+DateUtil.format(new Date(),"yyyyMMddHHmmss")+".csv";
        String realpath="C:\\wenbankLog\\"+fileName;
        CsvWriter writer = CsvUtil.getWriter(realpath, CharsetUtil.CHARSET_UTF_8);
        List a =new ArrayList();
        Double aa1=0.0D;
        Double aa2=0.0D;
        List<String> traids= CollUtil.newArrayList(data.split(";"));
        List<ArApEntity> ArApEntitys=arApMapper.getEntityByTraids(traids) ;
        for (ArApEntity arApEntity : ArApEntitys) {
            aa1+=Double.parseDouble(arApEntity.getOsTotal());
            aa2+=Double.parseDouble(arApEntity.getLocalToTal());
        }


        a.add(new String[]{"REC", "AR", "REC",DateUtil.format(new Date(),"yyyyMMdd"),DateUtil.format(new Date(),"yyyyMMdd"),param,ArApEntitys.get(0).getAccountCompanyName(),"DCR", traMatchDao.findAllone(param),"",param,ArApEntitys.get(0).getLocalCurrency(),aa1.toString(),aa2.toString()});
        for (ArApEntity arApEntity : ArApEntitys) {
            a.add(new String[]{"PTR", "AR", "INV",arApEntity.getTranNo(),arApEntity.getOsTotal(),arApEntity.getAccountCode()});

        }
        writer.write(a);
        //按行写出
        writer.close();
        response.setContentType("application/force-download");
        response.setHeader("content-disposition", "attachment;filename="+fileName);
        InputStream in = new FileInputStream(realpath);
        int len = 0;
        //5.创建数据缓冲区
        byte[] buffer = new byte[1024];
        //6.通过response对象获取OutputStream流
        OutputStream out = response.getOutputStream();
        //7.将FileInputStream流写入到buffer缓冲区
        while ((len = in.read(buffer)) > 0) {
            //8.使用OutputStream将缓冲区的数据输出到客户端浏览器
            out.write(buffer,0,len);
        }
        in.close();


    }

}
