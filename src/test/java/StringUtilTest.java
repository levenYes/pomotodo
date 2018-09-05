import static org.junit.Assert.*;

import java.util.Date;

import cn.liwenye.util.DateUtil;
import cn.liwenye.util.StrUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author liwenye
 * Created on 20180102
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class StringUtilTest {
    
    @Test
    public void getBookNameTest() {
    	String bookString = "33《海底两万里》222";
    	String bookName = StrUtil.getBookName(bookString);
    	assertEquals( "《海底两万里》",(bookName));  
    }
    
    @Test
    public void getBookNameTest2() {
    	String bookString = "#阅读 Python编程快速上手》";
    	String bookName = StrUtil.getBookName(bookString);
    	assertEquals( "",bookName);  
    }
    
    @Test
    public void testConvertDate() {
    	String date = "2018-09-05T00:16:58.000Z";
    	Date strDate = DateUtil.convertDate(date);
    	assertEquals( "2018-09-05 00:16:58",strDate.toString());  
    }

}
