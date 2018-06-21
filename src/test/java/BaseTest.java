import cn.liwenye.PomotodoServerApplication;
import cn.liwenye.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author LIWENYE
 *
 * @date 20180632
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PomotodoServerApplication.class)
public class BaseTest {
    @Autowired
    private MailService mailService;
    
    @Autowired
    private ImportNewRecordService importNewRecordService;
    
    @Test
    public void updateTest() {
    	importNewRecordService.update();
    }
}
