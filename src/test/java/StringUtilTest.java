import static org.junit.Assert.*;
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

}
