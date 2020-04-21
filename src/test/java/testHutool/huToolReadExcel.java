package testHutool;

import cn.hutool.core.lang.Console;
import cn.hutool.core.text.csv.CsvUtil;
import cn.hutool.core.text.csv.CsvWriter;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.XmlUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.sax.handler.RowHandler;
import com.example.demo.entity.company;

import java.io.File;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Auther: DELL
 * @Date: 2019/8/6 13:39
 * @Description:
 */
public class huToolReadExcel {

    public void readExcel(String path){
        //指定路径和编码
       /* CsvWriter writer = CsvUtil.getWriter("e:/testWrite.csv", CharsetUtil.CHARSET_UTF_8);
        List a =new ArrayList();


        a.add(new String[]{"a1", "b1", "c1"});
        a.add(new String[]{"a1", "b1", "c2"});
        writer.write(a);
//按行写出
        writer.close();*/

    }


    private RowHandler createRowHandler() {
        return new RowHandler() {
            @Override
            public void handle(int sheetIndex, int rowIndex, List<Object> rowlist) {
                Console.log("[{}] [{}] {}", sheetIndex, rowIndex, rowlist);
            }
        };
    }

    public String insertExcel_edi(File args) {
        ExcelReader reader = ExcelUtil.getReader(args.getAbsolutePath(),0);
        List<List<Object>> readAll = reader.read();
        System.out.println(readAll);
        ExcelReader reader1 = ExcelUtil.getReader(args.getAbsolutePath(),1);
        List<List<Object>> readAll1 = reader1.read();
        System.out.println(readAll1);
        //去除表头
        readAll.remove(0);
        readAll.remove(readAll.size()-1);
       /* for (List<Object> objects : readAll) {

           String orangantionCode=objects.get(2).toString()==""?"null":"'"+objects.get(2).toString()+"'";
           String orangantionName=objects.get(3).toString()==""?"null":"'"+objects.get(3).toString()+"'";
           String branchcode=objects.get(4).toString()==""?"null":"'"+objects.get(4).toString()+"'";
           String companyCode=objects.get(5).toString()==""?"null":"'"+objects.get(5).toString()+"'";
           String CREDIT_LIMIT=objects.get(6).toString();
           String IS_OVER_LIMIT=objects.get(7).toString()==""?"null":"'"+objects.get(7).toString()+"'";
           String STD_TERMS=objects.get(8).toString()==""?"null":"'"+objects.get(8).toString()+"'";
           String DSB_TERMS=objects.get(9).toString()==""?"null":"'"+objects.get(9).toString()+"'";
            String STD_OLDEST_DUE_DATE=objects.get(10).toString()==""?"null":"to_date('"+objects.get(10).toString()+"','yyyy-MM-dd')";
            String DSB_OLDEST_DUE_DATE=objects.get(11).toString()==""?"null":"to_date('"+objects.get(11).toString()+"','yyyy-MM-dd')";
            String TOTAL_OUTSTANDING=objects.get(12).toString()==""?"null":objects.get(12).toString();
            String TOTAL_CURRENT=objects.get(13).toString()==""?"null":objects.get(13).toString();
            String TOTAL_PAST_DUE=objects.get(14).toString()==""?"null":objects.get(14).toString();
            String STD_TERM_OUTSTANDING=objects.get(15).toString()==""?"null":objects.get(15).toString();
            String STD_CURRENT=objects.get(16).toString()==""?"null":objects.get(16).toString();
            String STD_PAST_DUE=objects.get(17).toString()==""?"null":objects.get(17).toString();
            String STD_AVG_DAYS_PAST_DUE=objects.get(18).toString()==""?"null":objects.get(18).toString();
            String DSB_TERM_OUTSTANDING=objects.get(19).toString()==""?"null":objects.get(19).toString();
            String DSB_CURRENT=objects.get(20).toString()==""?"null":objects.get(20).toString();
            String DSB_PAST_DUE=objects.get(21).toString()==""?"null":objects.get(21).toString();
            String ISCREDITONHOLD=objects.get(22).toString()==""?"null":"'"+objects.get(22).toString()+"'";
            String DSB_AVG_DAYS_PAST_DUE=objects.get(23).toString()==""?"null":objects.get(23).toString();
            String  insertSql="insert into dewell_edi.CW_ORG_PAYMENT_ANALYSIS values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s)";
            System.out.println(String.format(insertSql,orangantionCode,orangantionName,branchcode,companyCode,CREDIT_LIMIT,IS_OVER_LIMIT,
                    STD_TERMS,DSB_TERMS,STD_OLDEST_DUE_DATE,DSB_OLDEST_DUE_DATE,TOTAL_OUTSTANDING,TOTAL_CURRENT,TOTAL_PAST_DUE,STD_TERM_OUTSTANDING,STD_CURRENT
            ,STD_PAST_DUE,STD_AVG_DAYS_PAST_DUE,DSB_TERM_OUTSTANDING,DSB_CURRENT,DSB_PAST_DUE,ISCREDITONHOLD,DSB_AVG_DAYS_PAST_DUE));


        }*/
        return "news";
        }

    public static void main(String[] args) {
       //1.查正的总的
        //2.查负的总的
        //3.new一个set 查正的list和负的list都遍历去jobno放进去,为了第8步设置一个set放invoicenumber
        //4.遍历set，在遍历过程中根据job 分别去 正的带wehere的中查询得到正的集合，去分的带where条件差到负的集合
        //6.定义正的金额的map<金额，invoicenumber> map正，map<金额，invoicenumber> map负
        //7.得到集合后分别遍历正的和负的，把对应的数值put到map中
        //8.先遍历正的map,得到key为1100,则对应的是-1100去负数map中get.如果可以得到则把正的1000对应的，invoicenumber和负的得到的invoicenumber都发到set集合中。
        //9.在遍历负的map,得到key为11100,则对应的是1100去正数数map中get.如果可以得到则把负数的1000对应的，invoicenumber和正的得到的invoicenumber都发到set集合中。
        //10.循环完后放invoicenumber的set中的invoicenumber去update成Y就行了，参考时亚辉给你的查chargecode用set的那个就行了，吧select
        // 语句变为update m_accounting_transaction set SEND_STATUS=‘N’ where 后面就是forech循环那个
        /*BigDecimal c=new BigDecimal("-12456.12");
        BigDecimal e=new BigDecimal("12456.12");
        System.out.println(c);
        Map<BigDecimal,String> a =new HashMap<>();
        aput(c,"a");
        a.put(e,"b");
        System.out.println( a.get(c.abs()));.*/
        /*XmlUtil.toFile(
                XmlUtil.parseXml("<?xml version=\"1.0\" encoding=\"utf-8\"?><Res><Code>1</Code><Description>Success</Description></Res>"),"e:/testWrite.xml");
*/
         Set a =new HashSet<String>();
         a.add("a");
         a.add("b");
         a.add("c");

        Set B =new HashSet<String>();
        B.add("a");
        B.add("c");
        //B.add("b");
        System.out.println(a.containsAll(B));
    }


    }




