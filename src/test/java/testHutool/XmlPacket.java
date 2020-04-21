package testHutool;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;

import org.xml.sax.SAXException;

/**
 * 
 * ����XMLͨѶ������
 *
 */

public class XmlPacket{
	protected String termid;
	protected String trnid;
	protected String custid;
	protected String trncod;
	protected String token;
    protected String custdt;


	protected String RETCOD;
	protected String ERRMSG;
	protected Map data; //<String,Vector>
	
	public XmlPacket(){
		data = new Properties();
	}
	
	public XmlPacket(String termid){
		termid = termid;
		data = new Properties();
	}

	public XmlPacket(String termid, String trnid, String custid, String trncod, String token,String Custdt) {
		this.termid = termid;
		this.trnid = trnid;
		this.custid = custid;
		this.trncod = trncod;
		this.token = token;
		this.custdt=Custdt;
	}

	public String getCustdt() {
		return custdt;
	}

	public void setCustdt(String custdt) {
		this.custdt = custdt;
	}

	public String getTermid() {
		return termid;
	}

	public void setTermid(String termid) {
		this.termid = termid;
	}

	public String getTrnid() {
		return trnid;
	}

	public void setTrnid(String trnid) {
		this.trnid = trnid;
	}

	public String getCustid() {
		return custid;
	}

	public void setCustid(String custid) {
		this.custid = custid;
	}

	public String getTrncod() {
		return trncod;
	}

	public void setTrncod(String trncod) {
		this.trncod = trncod;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getRETCOD() {
		return RETCOD;
	}

	public void setRETCOD(String RETCOD) {
		this.RETCOD = RETCOD;
	}

	public String getERRMSG() {
		return ERRMSG;
	}

	public void setERRMSG(String ERRMSG) {
		this.ERRMSG = ERRMSG;
	}

	/**
	 *
	 * @return
	 */
	public boolean isError(){
		if(RETCOD.equals("0")){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * �������ݼ�¼
	 * @param sSectionName
	 * @param mpData <String, String>
	 */
	public void putProperty(String sSectionName, Map mpData){
		if(data.containsKey(sSectionName)){
			Vector vt = (Vector)data.get(sSectionName);
			vt.add(mpData);
		}else{
			Vector vt = new Vector();
			vt.add(mpData);
			data.put(sSectionName, vt);	
		}		
	}
	
	/**
	 * ȡ��ָ���ӿڵ����ݼ�¼
	 * @param sSectionName
	 * @param index ��������0��ʼ
	 * @return Map<String,String>
	 */
	public Map getProperty(String sSectionName, int index){
		if(data.containsKey(sSectionName)){
			return (Map)((Vector)data.get(sSectionName)).get(index);
		}else{
			return null;
		}
	}
	
	/**
	 * ȡ���ƶ��ӿ����ݼ�¼��
	 * @param sSectionName
	 * @return
	 */
	public int getSectionSize(String sSectionName){
		if(data.containsKey(sSectionName)){
			Vector sec = (Vector)data.get(sSectionName);
			return sec.size();
		}
		return 0;
	}
	
	/**
	 * 生成xml数据
	 * @return
	 */
	public String toXmlString(){
		StringBuffer sfData = new StringBuffer(
				"<?xml version='1.0' encoding = 'GB2312'?>");
		sfData.append("<bocb2e version='100' security='true' lang='chs'>");
		sfData.append("<head><termid>"+termid+"</termid><trnid>"+trnid+"</trnid><custid>"+custid+"</custid><cusopr>BOC</cusopr><trncod>"+trncod+"</trncod><token>"+token+"</token></head>");
		sfData.append("<trans>");
		sfData.append("<trn-"+trncod+"-rq>");
		sfData.append("<"+trncod+"-rq>");
		if (!custdt.isEmpty()){
			sfData.append("<custdt>"+custdt+"</custdt>");
		}
		sfData.append("</"+trncod+"-rq>");
		sfData.append("</trn-"+trncod+"-rq>");
		sfData.append("</trans>");
		sfData.append("</bocb2e>");
		return sfData.toString();
	}
	
	/**
	 * ����xml�ַ�������ת��Ϊ���Ķ���
	 * @param message
	 */
	public static XmlPacket valueOf(String message) {
		SAXParserFactory saxfac = SAXParserFactory.newInstance();
		try {
			SAXParser saxparser = saxfac.newSAXParser();
			ByteArrayInputStream is = new ByteArrayInputStream(message.getBytes());
			XmlPacket xmlPkt= new XmlPacket();
			saxparser.parse(is, new SaxHandler(xmlPkt));
			is.close();
			return xmlPkt;
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return null;
	}
}