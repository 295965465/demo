package com.example.demo.tool;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

/**
 * @Auther: DELL
 * @Date: 2019/12/27 15:49
 * @Description:
 */
public class HttpClientToDll {
    private void httpTest(String paymentId) {

       // String url="http://192.168.1.3:8079/dll/call/payment";
        String url="http://192.168.1.19:8000/ee0o833-wkmfk-23foi9-eikfm9-3kfm";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameter("pd", "123211");
            HttpGet get = new HttpGet(uriBuilder.build());
            httpClient.execute(get);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HttpClientToDll a = new HttpClientToDll();
        a.httpTest("aaa");
    }
}
