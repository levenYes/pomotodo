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
    //@Autowired
    HttpService HttpService = new HttpService();

    @Autowired
    BookListService bookListService;

    @Autowired
    private PomosMapper pomosMapper;

    @Autowired
    ImportHistoryService importHistoryService;

    @Autowired
    ImportNewRecordService importNewRecordService;

    @Autowired
    private MailService mailService;

    //@Autowired
    //private StringRedisTemplate stringRedisTemplate;
//
//    @Test
//    public void test1(){
//        String url = "https://api.pomotodo.com/1/account";
//        String result = HttpService.sendGet(url);
//        System.out.println(result);
//    }
//
//    @Test
//    public void test2(){
//        String url = "https://api.pomotodo.com/1/pomos?offset=0&limit=100&abandoned=false&manual=false&started_later_than=2010/01/08";
//        String data = HttpService.sendGet(url);
//        System.out.println(data);
//        //HttpService.importData(data);
//    }
//
//    @Test
//    public void test3(){
//        long beginTime = System.currentTimeMillis();
//        importHistoryService.importHistory();
//        long endTime=System.currentTimeMillis();
//        long costTime = (endTime - beginTime);
//        System.out.println("消耗时间为：" +costTime/1000 + "秒");
//    }
//
//    @Test
//    public void test4(){
//        bookListService.genBookList("D:\\\\file\\\\test.md");
//    }
//
//    @Test
//    public void test5(){
//        long beginTime = System.currentTimeMillis();
//        pomosMapper.deleteDuplicatedRecord();
//        long endTime=System.currentTimeMillis();
//        long costTime = (endTime - beginTime);
//        System.out.println("消耗时间为：" +costTime/1000 + "秒");
//    }
//
    @Test
    public void test7(){
    }
//
//    @Test
//    public void test8() {
//        //stringRedisTemplate.opsForValue().set("hello,", "world");
//        Calendar calendar1 = Calendar.getInstance();
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
//        calendar1.add(Calendar.DATE, -3);
//        String three_days_ago = sdf1.format(calendar1.getTime());
//        System.out.println(three_days_ago);
//
//    }

//    @Test
//    public void test9() {
//    	//获取“技术”标签的番茄数
//    	int numOfPomos = 0;
//    	TechPomos techPomos = pomosMapper.selectNumOfTechPomos();
//    	numOfPomos = techPomos.getNumOfTechPomos();
//    	
//    	//非整十的番茄数，返回
//    	if (numOfPomos % 10 > 0) return;
//    	
//		//跟缓存中的番茄数比较。若相同，返回
//    	CacheSingleton cacheSingleton = CacheSingleton.getCacheSingleton();
//    	if(CacheSingleton.getNumOfPomosSent() == numOfPomos) return;
//    	cacheSingleton.setNumOfPomosSent(numOfPomos);
//    	
//    	//发送邮件
//    	String to = "levenyes@icloud.com";
//        String title = "番茄数到达" + numOfPomos + "!";
//        String content = "番茄数到达" + numOfPomos + "!";
//        mailService.sendSimpleMail(to, title, content);
//    }
//
//    @Test
//    public void test10() {
//        String url = "https://api.pomotodo.com/1/account";
//        String result = HttpService.sendGet(url);
//        HashMap<String,String>  hashMap = new HashMap<String, String>(16);
//    }

}
