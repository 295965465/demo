import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.junit.Test;



import java.io.IOException;

/**
 * TODO(2019-05-30 16:38)
 *
 * @author stone
 * @version 1.0
 * @since JDK 1.7
 **/

public class JunitTest {
   @Test
    public  void mains() {
        JunitTest sss =new JunitTest();


        String str =


                "C00013630:"+
                        "C00028840:"
















                ;

                        String[] strArr = str.split(":");
        for (String s : strArr) {
            try {
                sss.httpTest(s);
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void httpTest(String consoleId) {
        //String url = "http://192.168.1.109:8080/cw1/parse-cargowise-xml/insertToEdi";
        String url="http://192.168.1.103:8888/cw1/parse-cargowise-xml/insertToEdi";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            URIBuilder uriBuilder = new URIBuilder(url);
            uriBuilder.addParameter("console", consoleId);
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
}
