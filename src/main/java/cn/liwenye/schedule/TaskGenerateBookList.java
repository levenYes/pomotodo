package cn.liwenye.schedule;

import cn.liwenye.service.BookListService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author Liwenye
 * @date 2018/01/10
 * 生成阅读记录定时任务类
 */
@Component
public class TaskGenerateBookList extends QuartzJobBean {

    @Autowired
    BookListService bookListService;

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        try {
            generateBookList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void generateBookList() throws Exception {
        bookListService.genBookList("/root/bookList/bookList.md");
    }
}
