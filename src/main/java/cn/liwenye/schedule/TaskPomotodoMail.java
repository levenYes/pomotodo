package cn.liwenye.schedule;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.liwenye.bean.TechPomos;
import cn.liwenye.cache.CacheSingleton;
import cn.liwenye.dao.PomosMapper;
import cn.liwenye.service.MailService;

public class TaskPomotodoMail extends QuartzJobBean {

	@Autowired
    private MailService mailService;

	@Autowired
	private PomosMapper pomosMapper;
	
    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        try {
            sendEmail();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void sendEmail() throws Exception {
    	//获取“技术”标签的番茄数
    	int numOfPomos = 0;
    	TechPomos techPomos = pomosMapper.selectNumOfTechPomos();
    	numOfPomos = techPomos.getNumOfTechPomos();
    	
    	//非整十的番茄数，返回
    	if (numOfPomos % 5 > 0) return;
    	
		//跟缓存中的番茄数比较。若相同，返回
    	CacheSingleton.getCacheSingleton();
    	if(CacheSingleton.getNumOfPomosSent() == numOfPomos) return;
        CacheSingleton.setNumOfPomosSent(numOfPomos);
    	
    	//发送邮件
    	String to = "levenyes@icloud.com";
        String title = "番茄数到达" + numOfPomos + "!";
        String content = "番茄数到达" + numOfPomos + "!";
        mailService.sendSimpleMail(to, title, content);
    }
}
