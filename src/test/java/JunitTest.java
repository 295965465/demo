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
                "C00051247:"+
                        "C00051233:"+
                        "C00051232:"+
                        "C00051231:"+
                        "C00051147:"+
                        "C00051032:"+
                        "C00051027:"+
                        "C00051022:"+
                        "C00051020:"+
                        "C00051019:"+
                        "C00051016:"+
                        "C00051014:"+
                        "C00051009:"+
                        "C00051005:"+
                        "C00051003:"+
                        "C00051001:"+
                        "C00051000:"+
                        "C00050997:"+
                        "C00050996:"+
                        "C00050995:"+
                        "C00050994:"+
                        "C00050993:"+
                        "C00050991:"+
                        "C00050989:"+
                        "C00050988:"+
                        "C00050986:"+
                        "C00050985:"+
                        "C00050983:"+
                        "C00050982:"+
                        "C00050981:"+
                        "C00050980:"+
                        "C00050979:"+
                        "C00050978:"+
                        "C00050976:"+
                        "C00050975:"+
                        "C00050973:"+
                        "C00050967:"+
                        "C00050965:"+
                        "C00050962:"+
                        "C00050960:"+
                        "C00050959:"+
                        "C00050958:"+
                        "C00050957:"+
                        "C00050954:"+
                        "C00050951:"+
                        "C00050950:"+
                        "C00050949:"+
                        "C00050948:"+
                        "C00050939:"+
                        "C00050930:"+
                        "C00050928:"+
                        "C00050927:"+
                        "C00050926:"+
                        "C00050924:"+
                        "C00050923:"+
                        "C00050922:"+
                        "C00050921:"+
                        "C00050920:"+
                        "C00050919:"+
                        "C00050918:"+
                        "C00050915:"+
                        "C00050914:"+
                        "C00050913:"+
                        "C00050911:"+
                        "C00050910:"+
                        "C00050906:"+
                        "C00050905:"+
                        "C00050904:"+
                        "C00050900:"+
                        "C00050898:"+
                        "C00050897:"+
                        "C00050896:"+
                        "C00050894:"+
                        "C00050891:"+
                        "C00050890:"+
                        "C00050889:"+
                        "C00050887:"+
                        "C00050885:"+
                        "C00050881:"+
                        "C00050878:"
                ;












































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
        String url = "http://192.168.1.109:8080/cw1/parse-cargowise-xml/insertToEdi";
        // String url="http://192.168.1.103:8888/cw1/parse-cargowise-xml/insertToEdi";
        //String url="http://192.168.1.3:8079/dll/call/payment";
        CloseableHttpClient httpClient = HttpClients.createDefault();
        try {
            URIBuilder uriBuilder = new URIBuilder(url);

            //参数名是：console
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
