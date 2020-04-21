package testHutool;

import cn.hutool.http.*;
import cn.hutool.http.HttpRequest;

import java.net.URLEncoder;

/**
 * @Auther: DELL
 * @Date: 2020/4/9 10:07
 * @Description:
 */
public class testcc {
    public static void main(String[] args) throws Exception {
       String a=",DWEC,DWHC,DWFC,DWSC,DWUC,DWBGD,,DWTH,DWSG,DWKR,SUBAGENT,SUNM,JASINDO,ROSEMOUNT,PRICARGO,THORESEN,ZIEGLER FRANCE,SWIFT FREIGHT,IN_CREST,AGAPE,WICE,TWGM,ALLSYS,WINPLUS,UNION CHAMPION,JEMARA,DWVN,DWDC,DEWELL,EAST CHINA,DWKN,DWXM,DWFZ,DWSH,DWNB,DWDM,DWJX,DWHZ,00412,DWXS,DWSN,SOUTH CHN,DWGZ,DWSZ,DWHK,DWZS,DWNN,DWSA,DWZN,DWID,NORTH CHINA,DWJSU,DWNJ,DWNT,DWHF,DWDL,DWQD,DWWH,DWCQ,DWTJ,DWBN,DE WELL(USA),01585,00083,00066,00002,00001,00070,00071,00096,DWCHQ,DWMY,DWIN";
        if (a.startsWith(",")){

         a=  a.substring(1);
        }
        a="'"+a.replaceAll(",","','")+"'";
        System.out.println(a);
    }
}
