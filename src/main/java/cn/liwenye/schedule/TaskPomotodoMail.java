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
            sendEmail();
    }

    public void sendEmail(){
    	TechPomos techPomos = pomosMapper.selectNumOfTechPomos();
    	int numOfTechPomos = techPomos.getNumOfTechPomos();
    	
    	if (numOfTechPomos % 5 > 0) {
    		return;
    	}
    	
    	CacheSingleton.getCacheSingleton();
    	if(CacheSingleton.getNumOfPomosSent() == numOfTechPomos) {
    		return;
    	} else {
    		CacheSingleton.setNumOfPomosSent(numOfTechPomos);
    	}
    	
    	String to = "levenyes@icloud.com";
        String title = "番茄数到达" + numOfTechPomos + "!";
        String statement = "番茄数到达" + numOfTechPomos + "!";
        StringBuilder content = new StringBuilder();
        for (int i=0; i < 10; i++) {
        	content.append(statement).append("\n");
        }
        mailService.sendSimpleMail(to, title, content.toString());
    }
}
