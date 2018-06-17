package cn.liwenye.service;

import cn.liwenye.bean.Booklist;
import cn.liwenye.dao.PomosMapper;
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
    PomosMapper pomosMapper;
    
    private static final double HOUR_PER_POMOTODO = 0.5;

    public void genBookList(String pathname){
        List<Booklist> bookList = pomosMapper.selectBooklist();
        String subTitle = "";
        List<String> mdContent = new ArrayList<String>(16);
        TxtUtil.initMdContent(mdContent);
        for(Booklist bookRecord : bookList){
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
                    + "       最近阅读: " + lastDate
                    + "       累计用时: " + totalHours + "h";
            mdContent.add(contentRow);
        }
        File mdFile = new File(pathname);
        TxtUtil.writeTxt(mdFile,mdContent);
    }
}
