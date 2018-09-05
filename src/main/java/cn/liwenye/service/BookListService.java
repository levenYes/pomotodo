package cn.liwenye.service;

import cn.liwenye.bean.BookList;
import cn.liwenye.util.StrUtil;
import cn.liwenye.util.TxtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liwenye on 2018/01/08
 */
@Service
public class BookListService {

    @Autowired
    DaoService daoService;
    
    private static final double HOUR_PER_POMOTODO = 0.5;

    public void genBookList(String path){
    	List<String> mdContent = genBookListContent();
        File mdFile = new File(path);
        TxtUtil.writeTxt(mdFile,mdContent);
    }
    
    private List<String> genBookListContent() {
         List<String> mdContent = new ArrayList<String>(16);
         TxtUtil.initMdContent(mdContent);
         String subTitle = "";
         List<BookList> bookList = daoService.bookListQuery();
         for(BookList bookRecord : bookList){
             String book = bookRecord.getBook();
             Date date = bookRecord.getLastDay();
             int totalPomos = bookRecord.getTotalPomos();
             double totalHours = totalPomos * HOUR_PER_POMOTODO;
             String lastDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
             String yearAndMonth = lastDate.substring(0,7);
             
             if(!subTitle.equals(yearAndMonth) && yearAndMonth != null){
                 subTitle = yearAndMonth;
                 String titleRow = "## " + subTitle;
                 mdContent.add(titleRow);
             }
             
             String bookName = StrUtil.getBookName(book);
             if(StringUtils.isEmpty(bookName)) {
                 continue;
             }
             String contentRow = bookName
                     + "       最后一次阅读: " + lastDate
                     + "       历史累计用时: " + totalHours + "h";
             mdContent.add(contentRow);
         }
         return mdContent;
    }
    
}
