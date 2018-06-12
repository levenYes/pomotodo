import cn.liwenye.PomotodoServerApplication;
import cn.liwenye.bean.TechPomos;
import cn.liwenye.cache.CacheSingleton;
import cn.liwenye.dao.PomosMapper;
import cn.liwenye.service.*;
import cn.liwenye.util.StrUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;


/**
 * @author liwenye
 * Created on 20180102
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = PomotodoServerApplication.class)
public class BaseTest {
    @Autowired
    private MailService mailService;
    
    @Test
    public void mailTest() {
    	//发送邮件
    	String to = "levenyes@icloud.com";
        String title = "testing";
        String content = "test ok!";
        mailService.sendSimpleMail(to, title, content);
    }

}
