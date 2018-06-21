package cn.liwenye.schedule;

import cn.liwenye.service.BookListService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author LIWENYE
 * @date 2018/01/10
 * 生成阅读记录定时任务类
 */
@Component
public class TaskGenerateBookList extends QuartzJobBean {
    private Log logger = LogFactory.getLog(TaskGenerateBookList.class);

    @Autowired
    BookListService bookListService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        try {
            generateBookList();
        } catch (Exception e) {
            logger.error("生成阅读记录文件发生异常", e);
        }
    }

    public void generateBookList() {
        bookListService.genBookList("/root/bookList/bookList.md");
    }
}
