
import org.apache.http.*;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.FileEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO(2019-05-30 16:38)
 *
 * @author stone
 * @version 1.0
 * @since JDK 1.7
 **/

public class shipmentETAupate {
   @Test
    public  void mains() {
        shipmentETAupate sss =new shipmentETAupate();


        String str =

                        "S25WS0000045/2019-11-25/2019-11-23:"+
                        "S35ES0000147/2019-12-07/2019-12-09:"+
                        "SGGZS0000351/2019-11-18/2019-11-17:"+
                        "SQINS0002163/2019-12-11/2019-12-10:"+
                        "SSHAS0018024/2019-11-28/2019-11-30:"+
                        "SSHAS0018318/2019-12-01/2019-11-29:"+
                        "SSHAS0018431/2019-11-28/2019-11-30:"+
                        "SSNZS0005264/2019-12-09/2019-12-10:"+
                        "STXGS0000564/2019-11-20/2019-12-03:"


































                ;

                       String[] strArr = str.split(":");
        for (String s : strArr) {
            String [] shipmentss=s.split("/");
            System.out.println("shipmentid:"+shipmentss[0]+"legEta:"+shipmentss[2]);
            try {
                Thread.currentThread().sleep(10000);
                sss.creatxmltocw1foredi(shipmentss[0],shipmentss[2]);
            } catch (Exception e) {
                e.printStackTrace();
            }


        }

   }
    public  void creatxmltocw1foredi(String shipmentid,String shpmenteta) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String filename="webBank-Request"+sdf.format(new Date())+".xml";
        String path="C:/dewell-gtnexus/pick_up/gtnexus/Bookingstaus/"+filename;

        Document document = DocumentHelper.createDocument();
        Element root = document.addElement("UniversalShipment", "http://www.cargowise.com/Schemas/Universal/2011/11");
        root.addAttribute("version","1.1");
        Element Shipment=root.addElement("Shipment");
        Element DataContext=Shipment.addElement("DataContext");
        Element DataTargetCollection=DataContext.addElement("DataTargetCollection");
        Element DataTarget=DataTargetCollection.addElement("DataTarget");
        DataTarget.addElement("Type").addText("ForwardingShipment");
        DataTarget.addElement("Key").addText(shipmentid);
        Element DateCollection=Shipment.addElement("DateCollection");
        Element Date=DateCollection.addElement("Date");
        Date.addElement("Type").addText("Arrival");
        Date.addElement("IsEstimate").addText("true");
        Date.addElement("Value").addText(shpmenteta);
        OutputFormat format = new OutputFormat("    ", true);
        format.setEncoding("utf-8");


        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path), format);
        xmlWriter.write(document);
        xmlWriter.close();
        sendFileToCw1(new File(path));

    }
    public static void sendFileToCw1(File file) {
        CloseableHttpResponse closeableHttpResponse;
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpEntity entity = new FileEntity(file);
        HttpPost httpPost = new HttpPost("http://192.168.1.109:8080/cw1/http/interaction.action");
        httpPost.setEntity(entity);
        try {
            closeableHttpResponse = httpClient.execute(httpPost);
            entity = closeableHttpResponse.getEntity();

            System.out.println(entity);
            httpClient.close();
            closeableHttpResponse.close();

        } catch (Exception e) {
            System.out.println("HttpUtil 请求中间件出错:"+e.getMessage());

        }
    }
    }

