package testHutool;

import java.io.*;
import java.net.*;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * HTTPͨѶ����: ֱ��֧��
 * 
 */
public class HttpRequest {
	/**
	 * ����������
	 * 
	 * @return
	 */
	private String getRequestStr() {

		XmlPacket xmlPkt = new XmlPacket("E127000000001", "20060704001","12345678","b2e0008","9TTQALYGH1","20060704101000");
		return xmlPkt.toXmlString();
	}

	/**
	 *
	 * 
	 * @param data
	 * @return
	 * @throws MalformedURLException
	 */
	private String sendRequest(String data) {
		String result = "";
		try {
			URL url;
			url = new URL("http://192.168.1.3:8080");

			HttpURLConnection conn;
			conn = (HttpURLConnection) url.openConnection();

			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			System.out.println(conn.getContent());
			OutputStream os;
			os = conn.getOutputStream();
			os.write(data.toString().getBytes("gbk"));
			os.close();

			BufferedReader br = new BufferedReader(new InputStreamReader(conn
					.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				result += line;
			}

			System.out.println(result);
			br.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 *
	 * 
	 * @param result
	 */
	private void processResult(String result) {
		if (result != null && result.length() > 0) {
			XmlPacket pktRsp = XmlPacket.valueOf(result);
			if (pktRsp != null) {
				String sRetCod = pktRsp.getRETCOD();
				String messge = pktRsp.getERRMSG();
				System.out.println(sRetCod+"llll"+messge);

			}
		}
	}

	public static void main(String[] args) {
		try {
			HttpRequest request = new HttpRequest();

			String data = request.getRequestStr();
			//XmlPacket pktRsp = XmlPacket.valueOf(data);
			String result = request.sendRequest(data);

			request.processResult(result);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}