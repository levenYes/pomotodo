package cn.liwenye.service;

import cn.liwenye.bean.Booklist;
import cn.liwenye.dao.PomosMapper;
import cn.liwenye.util.StrUtil;
import cn.liwenye.util.TxtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void genBookList(String pathname){
        List<Booklist> booklist = pomosMapper.selectBooklist();
        String subTitle = "";
        List<String> mdContent = new ArrayList<String>(16);
        TxtUtil.initMdContent(mdContent);
        for(int i = 0; i<booklist.size(); i++){
            String book = booklist.get(i).getBook();
            Date date =booklist.get(i).getLastDay();
            int totalPomos = booklist.get(i).getTotalPomos();
            double totalHours = totalPomos * 0.5;
            String lastDate;
            lastDate = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String yearAndMonth = lastDate.substring(0,7);
            if(!subTitle.equals(yearAndMonth)){
                subTitle = yearAndMonth;
                String titleRow = "## " + subTitle;
                mdContent.add(titleRow);
            }
            String contentRow = StrUtil.getBookName(book)
                    + "       最近阅读: " + lastDate
                    + "       累计用时: " + totalHours + "h";
            mdContent.add(contentRow);
        }
        //打开预设文件
        File mdFile = new File(pathname);
        TxtUtil.writeTxt(mdFile,mdContent);
    }
}
