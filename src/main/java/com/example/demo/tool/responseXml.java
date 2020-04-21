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
public class responseXml {
    public void createresponsetXml()throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        String filename="webBank-response"+sdf.format(new Date())+".xml";
        String path="C:/dewell-gtnexus/pick_up/gtnexus/Bookingstaus/"+filename;
        Element root = DocumentHelper.createElement("CMBSDKPGK");
        Document document = DocumentHelper.createDocument(root);
        Element INfo=root.addElement("INFO");
        INfo.addElement("FUNNAM").addText("Payment");
        INfo.addElement("DATTYP").addText("2");
        INfo.addElement("LGNNAM").addText("ZL01");
        INfo.addElement("ERRMSG").addText("ZL01");
        Element NTQPAYRQZ=root.addElement("NTQPAYRQZ");
        NTQPAYRQZ.addElement("ERRCOD").addText("N02031");
        NTQPAYRQZ.addElement("REQNBR").addText("00001");
        NTQPAYRQZ.addElement("REQSTS").addText("00001");
        NTQPAYRQZ.addElement("SQRNBR").addText("00001");
        NTQPAYRQZ.addElement("YURREF").addText("00001");

        OutputFormat format = new OutputFormat("    ", true);
        format.setEncoding("utf-8");


        XMLWriter xmlWriter = new XMLWriter(new FileOutputStream(path), format);
        xmlWriter.write(document);
        xmlWriter.close();




    }

    public static void main(String[] args) {
        responseXml a = new responseXml();
        try {
            a.createresponsetXml();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
