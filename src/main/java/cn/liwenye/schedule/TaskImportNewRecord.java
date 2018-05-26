package cn.liwenye.schedule;

import cn.liwenye.service.ImportNewRecordService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * @author Liwenye
 * @date 2018/01/09
 * 插入新数据定时任务类
 */
@Component
public class TaskImportNewRecord extends QuartzJobBean {
	private Log log = LogFactory.getLog(TaskImportNewRecord.class);
	
    @Autowired
    ImportNewRecordService importNewRecordService;

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        try {
            insert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insert() throws Exception {
        importNewRecordService.update();
    }
}
