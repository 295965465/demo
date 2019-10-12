import com.example.demo.DemoApplication;
import com.example.demo.service.paymentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Auther: DELL
 * @Date: 2019/10/12 14:09
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class myjpatest {
    @Autowired
    private paymentService paymentServiceIImp;
    @Test
    public  void  mytest(){
      String  myst=paymentServiceIImp.testDate();
        System.out.println(myst);
    }
}
