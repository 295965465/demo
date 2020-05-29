package com.example.demo.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.aspect.Log;
import com.example.demo.dao.AccountDao;
import com.example.demo.dao.AccountingChargesDao;

import com.example.demo.dao.companyDao;
import com.example.demo.dao.traMatchDao;
import com.example.demo.entity.*;
import com.example.demo.mapper.ArApMapper;
import lombok.extern.slf4j.Slf4j;

import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: DELL
 * @Date: 2020/4/10 13:57
 * @Description:
 */

@Controller
@RequestMapping("/ArAp")
@Slf4j
public class ArApController {
    @Resource
    private ArApMapper arApMapper;
    @Resource
    private companyDao companyDao;
    @Resource
    private traMatchDao traMatchDao;
    @Resource
    private AccountDao accountDao;
    @Resource
    private AccountingChargesDao accountingChargeDao;
    @RequestMapping(value = "/initArAPTable",method = RequestMethod.POST)
    @ResponseBody
    @Log("ArAp查数据")
    public Map<String,Object> getDate(@Param(value = "page") int page, @Param(value = "limit")int limit
                                      ,@Param(value = "param") String param,@Param(value = "status") String status
            ,@Param(value = "seachstatus") String seachstatus ,@Param(value = "postdatetiemRange") String postdatetiemRange
            ,@Param(value = "invoicedatetiemRange") String invoicedatetiemRange
            ,@Param(value = "invoiceNo") String invoiceNo,HttpSession HttpSession){
        String usercode= HttpSession.getAttribute("userCode").toString();
        String conpanycode=companyDao.getsubCompycode(usercode); //获取subcompaycode
        List<String> branchList=arApMapper.getCompanyCode(conpanycode);
        if (conpanycode.startsWith(",")){
            conpanycode=conpanycode.substring(1);
        }
        log.info("AP?AP==={}",status);
        conpanycode="('"+conpanycode.replaceAll(",","','")+"')";
        Map<String,Object> map=new HashMap<>();
        Date fromdate=null;
        Date todate=null;
        Date fromdate1=null;
        Date todate1=null;
        if(StrUtil.isNotBlank(postdatetiemRange)){
            fromdate= DateUtil.parse(postdatetiemRange.split(" - ")[0],"yyyy-MM-dd hh:mm:ss");
            todate=DateUtil.parse(postdatetiemRange.split(" - ")[1],"yyyy-MM-dd hh:mm:ss");

        }
        if(StrUtil.isNotBlank(invoicedatetiemRange)){
            fromdate1= DateUtil.parse(invoicedatetiemRange.split(" - ")[0],"yyyy-MM-dd hh:mm:ss");
            todate1=DateUtil.parse(invoicedatetiemRange.split(" - ")[1],"yyyy-MM-dd hh:mm:ss");

        }
        IPage<ArApEntity> ar = arApMapper.getAllArAp(new Page<>(page, limit), status,branchList,
                fromdate, todate, fromdate1,todate1,param,seachstatus,invoiceNo);
        map.put("data",ar.getRecords());
        map.put("code",0);
        map.put("msg","");
        map.put("count",ar.getTotal());
        return map;
    }
    @GetMapping(value = "/getDetail/{traId}")
    @ResponseBody
    public Map<String,Object> getApArDetail(@PathVariable("traId") String traId){

      log.info("TraId:{}",traId);
        Map<String, Object> model = new HashMap<>();
        List<AccountingCharges> accountingCharges = accountingChargeDao.findbyTraid(traId);
        model.put("data",accountingCharges);
        model.put("code",0);
        model.put("msg","");
        model.put("count",accountingCharges.size());
        return model;
    }

    @RequestMapping(value = "/goArApDetail/{traId}")
    public String goArApDetail(Model model,@PathVariable("traId") String traId) {
        model.addAttribute("traId",traId);

        return "ArApDetail";


    }

    @RequestMapping(value = "/getAccountCode",method =RequestMethod.POST)
    @ResponseBody
    public List<ArApEntity> getAccountCode(@Param("seachparam") String seachparam) {
        List<ArApEntity> accountCode = arApMapper.getAccountCode(seachparam.trim());

        return accountCode;


    }
    @RequestMapping(value = "/insertMatch",method =RequestMethod.POST)
    public String insertMatch(@Param("data") String data, @Param("accountcode")String accountcode, @Param("accountNumber") String accountNumber, HttpSession model ) {
        log.info("data{},accountcode{}",data,accountcode);
        Tra tra= JSONUtil.toBean(JSONUtil.parseObj(data.replaceAll("\\[","").replaceAll("\\]","")),Tra.class);
        model.setAttribute("Haccountcode",accountcode);
        TraMatch TraMatch=new TraMatch();
        TraMatch.setRpyacc(tra.getRpyacc());
        TraMatch.setRpybnk(tra.getRpybnk());
        TraMatch.setRpynam(tra.getRpynam());
        TraMatch.setTrsamt(tra.getTrsamt());
        TraMatch.setCwAccountCode(accountcode);
        TraMatch.setCwBankCode(accountDao.getcityAndName(accountNumber.split(":")[0]).getWebBankCode());
        traMatchDao.save(TraMatch);

        return "Ar";


    }
    @RequestMapping(value = "/goAr")
    public String login(Model model, String name, HttpSession session) {


        return "Ar";


    }

    @RequestMapping(value = "/goAp")
    public String goAP(Model model, String name, HttpSession session) {


        return "Ap";


    }
}
