package cn.liwenye.schedule;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import cn.liwenye.service.ImportNewRecordService;

/**
 * @author LIWENYE
 * @date 2018/01/09
 * 插入新数据定时任务类
 */
@Component
public class TaskImportNewRecord extends QuartzJobBean {
	private Log logger = LogFactory.getLog(TaskImportNewRecord.class);
	
    @Autowired
    ImportNewRecordService importNewRecordService;

    @Override
    protected void executeInternal(JobExecutionContext context) {
        try {
            update();
        } catch (Exception e) {
        	logger.error("执行插入新数据定时任务方法发生异常", e);
        }
    }

    public void update() {
        importNewRecordService.update();
    }
}
