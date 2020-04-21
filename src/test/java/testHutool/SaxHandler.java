package testHutool;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


import java.util.*;


/**
 * 
 * ����XML���Ľ�����
 *
 */
public class SaxHandler extends DefaultHandler {
	int layer=0;
	String curSectionName;
	String curKey;
	String curValue;
	XmlPacket pktData;
	Map mpRecord;
	
	public SaxHandler(XmlPacket data){
		curSectionName = "";
		curKey = "";
		curValue = "";
		pktData = data;
		mpRecord = new Properties();
	}

	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		layer++;
		if(layer==4){
			curSectionName = qName;
		}else if(layer==5){
			curKey = qName;
		}
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if(layer==4){
			pktData.putProperty(curSectionName, mpRecord);
			mpRecord = new Properties();
		}else if(layer==5){
			mpRecord.put(curKey, curValue);
			if(curSectionName.equals("status")){

				  if(curKey.equals("rspcod")){
					pktData.setRETCOD(curValue);
				}else if(curKey.equals("errmsg")){
					pktData.setERRMSG(curValue);
				}
			}
		}
		curValue = "";
		layer--;
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if(layer==5){
			String value = new String(ch, start, length);
			if(ch.equals("\n")){
				curValue += "\r\n";
			}else{
				curValue += value;
			}
		}
	}
}
