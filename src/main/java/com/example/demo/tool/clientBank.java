package com.example.demo.tool;

import cn.hutool.http.HttpUtil;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.HashMap;

/**
 * @Auther: DELL
 * @Date: 2019/10/23 09:20
 * @Description:
 */
public class clientBank {
    public static void main(String[] args) {
        HashMap<String, String> paramMap = new HashMap<>();
        paramMap.put("server", "192.168.1.77");
        paramMap.put("Port", "2222");
        paramMap.put("sUser", "FRAN");
        paramMap.put("serverBOC", "192.168.1.77");
        paramMap.put("PortBOC", "8080");
        paramMap.put("sUSERBOC", "15607801");
        //String rest= HttpUtil.post("http://192.168.1.77:8080/B2EC/E2BServlet",paramMap);
        String rest= HttpUtil.get("http://192.168.1.19:8000/ee0o833-wkmfk-23foi9-eikfm9-3kfm?pd=123211");
        System.out.println(rest);
        //String url = "http://192.168.1.77:8080/B2EC/E2BServlet";


    }
    public  void testwebsockt(String url){
        WebSocketClient webSocketClient=new WebSocketClient(URI.create(url)) {
            @Override
            public void onOpen(ServerHandshake serverHandshake) {
                System.out.println("打开链接");
            }

            @Override
            public void onMessage(String s) {
                System.out.println(s);
            }

            @Override
            public void onClose(int i, String s, boolean b) {
                System.out.println("链接已关闭");
            }

            @Override
            public void onError(Exception e) {
                e.printStackTrace();
                System.out.println("发生错误已关闭");
            }
        };
        webSocketClient.connect();
        System.out.println(webSocketClient.getDraft());
        while(!webSocketClient.getReadyState().equals(ReadyState.OPEN)){
            System.out.println("正在连接");
        }
        System.out.println("打开了");
        try {
            String filename = "C:\\Users\\knowologe\\Desktop\\8k16bit.wav";
            byte[] data=InputStream2ByteArray(filename);
//            for(int i=0;i<5;i++){
            webSocketClient.send(data);
//                Thread.sleep(1000);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
   /* public static void send(byte[] bytes,WebSocketClient client){
        client.send(bytes);
    }*/

    private static byte[] InputStream2ByteArray(String filePath) throws IOException {

        InputStream in = new FileInputStream(filePath);
        byte[] data = toByteArray(in);
        in.close();

        return data;
    }

    private static byte[] toByteArray(InputStream in) throws IOException {

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024 * 4];
        int n = 0;
        while ((n = in.read(buffer)) != -1) {
            out.write(buffer, 0, n);
        }
        return out.toByteArray();
    }


    }

