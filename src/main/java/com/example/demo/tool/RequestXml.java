package com.example.demo.tool;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Auther: DELL
 * @Date: 2019/10/23 09:53
 * @Description:
 */
public class RequestXml {
    public void createRequestXml()throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyMMddSSS");

        String filename="webBank-Request"+sdf.format(new Date())+".xml";
        String path="C:/dewell-gtnexus/pick_up/gtnexus/Bookingstaus/"+filename;

        Element root = DocumentHelper.createElement("bocb2e");
        root.addAttribute("version","100");
        root.addAttribute("security","true");
        root.addAttribute("lang","chs");
        Document document = DocumentHelper.createDocument(root);
        Element INfo=root.addElement("head");
        INfo.addElement("termid").addText("Payment");
        INfo.addElement("trnid").addText("");
        INfo.addElement("custid").addText("ZL01");
        INfo.addElement("cusopr").addText("BOC");
        INfo.addElement("trncod").addText("ZL01");
        INfo.addElement("token").addText("ZL01");

        Element SDKPAYRQX=root.addElement("SDKPAYRQX");
        SDKPAYRQX.addElement("BUSCOD").addText("N02031");
        SDKPAYRQX.addElement("BUSMOD").addText("00001");
        Element SDKPAYDTX=root.addElement("SDKPAYDTX");
        SDKPAYDTX.addElement("YURREF").addText("N02031");
        SDKPAYDTX.addElement("EPTDAT").addText("00001");
        SDKPAYDTX.addElement("EPTTIM").addText("N02031");
        SDKPAYDTX.addElement("DBTACC").addText("00001");
        SDKPAYDTX.addElement("C_DBTBBK").addText("N02031");
        SDKPAYDTX.addElement("TRSAMT").addText("00001");
        SDKPAYDTX.addElement("C_CCYNBR").addText("N02031");
        SDKPAYDTX.addElement("C_STLCHN").addText("00001");
        SDKPAYDTX.addElement("NUSAGE").addText("N02031");
        SDKPAYDTX.addElement("CRTACC").addText("00001");
        SDKPAYDTX.addElement("CRTNAM").addText("N02031");
        SDKPAYDTX.addElement("CRTBNK").addText("00001");
        SDKPAYDTX.addElement("CRTPVC").addText("N02031");
        SDKPAYDTX.addElement("CRTCTY").addText("00001");
        SDKPAYDTX.addElement("CRTSQN").addText("N02031");
        OutputFormat format = new OutputFormat("    ", true);
        format.setEncoding("GB2312");


        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path), format);
        xmlWriter.write(document);
        xmlWriter.close();




    }

    public static void main(String[] args) {
        RequestXml a = new RequestXml();
        try {
            a.createRequestXml();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
