package testHutool;

import cn.hutool.http.*;
import cn.hutool.http.HttpRequest;
import cn.hutool.json.JSONUtil;
import com.example.demo.entity.Tra;
import org.springframework.util.StringUtils;

import java.net.URLEncoder;
import java.util.List;

/**
 * @Auther: DELL
 * @Date: 2020/4/9 10:07
 * @Description:
 */
public class testcc {
    public static void main(String[] args) throws Exception {
      String a="[{\"traId\":\"980000\",\"soNo\":\"HDMUNXNY2210009\",\"mbl\":\"HDMUNXNY2210009\",\"invoiceNo\":\"SNGBS0007320/D\",\"tranNo\":\"NGB2005000227\",\"accountCode\":\"L-SHAJOYSXG\",\"accountCompanyName\":\"绍兴悦天纺织服装有限公司\",\"postDate\":1588953600000,\"invoiceDate\":1588953600000,\"dueDate\":1592582400000,\"transactionType\":\"INV\",\"fullyPaidDate\":null,\"localToTal\":\"6572\",\"localCurrency\":\"CNY\",\"osTotal\":\"6572\",\"outstandingAmount\":\"6572\",\"osCurreny\":\"CNY\",\"onumber\":null,\"ojobInvoiceNumber\":null},{\"traId\":\"980000\",\"soNo\":\"HDMUNXNY2210009\",\"mbl\":\"HDMUNXNY2210009\",\"invoiceNo\":\"SNGBS0007320/D\",\"tranNo\":\"NGB2005000227\",\"accountCode\":\"L-SHAJOYSXG\",\"accountCompanyName\":\"绍兴悦天纺织服装有限公司\",\"postDate\":1588953600000,\"invoiceDate\":1588953600000,\"dueDate\":1592582400000,\"transactionType\":\"INV\",\"fullyPaidDate\":null,\"localToTal\":\"6572\",\"localCurrency\":\"CNY\",\"osTotal\":\"6572\",\"outstandingAmount\":\"6572\",\"osCurreny\":\"CNY\",\"onumber\":null,\"ojobInvoiceNumber\":null}]";
        List<Tra> tra= JSONUtil.toList(JSONUtil.parseArray(a),Tra.class);
        System.out.println(tra);
    }
}
