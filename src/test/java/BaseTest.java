import cn.liwenye.PomotodoServerApplication;
import cn.liwenye.dao.PomosMapper;
import cn.liwenye.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.lang.reflect.Proxy;

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

    @Test
    public void test1(){
        String url = "https://api.pomotodo.com/1/account";
        String result = HttpService.sendGet(url);
        System.out.println(result);
    }

    @Test
    public void test2(){
        String url = "https://api.pomotodo.com/1/pomos?offset=0&limit=100&abandoned=false&manual=false&started_later_than=2018/01/08";
        String data = HttpService.sendGet(url);
        System.out.println(data);
        //HttpService.importData(data);
    }

    @Test
    public void test3(){
        long beginTime = System.currentTimeMillis();
        importHistoryService.importHistory();
        long endTime=System.currentTimeMillis();
        long costTime = (endTime - beginTime);
        System.out.println("消耗时间为：" +costTime/1000 + "秒");
    }

    @Test
    public void test4(){
        bookListService.genBookList("D:\\\\file\\\\test.md");
    }

    @Test
    public void test5(){
        long beginTime = System.currentTimeMillis();
        pomosMapper.deleteDuplicatedRecord();
        long endTime=System.currentTimeMillis();
        long costTime = (endTime - beginTime);
        System.out.println("消耗时间为：" +costTime/1000 + "秒");
    }

    @Test
    public void test7(){
        importNewRecordService.update();
    }

}
