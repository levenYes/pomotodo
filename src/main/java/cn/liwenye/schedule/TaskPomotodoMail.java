package cn.liwenye.schedule;

import cn.liwenye.bean.ReadPomos;
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

	private static int repeatTimes = 10;

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
		sendTechEmail();
		sendReadEmail();
    }

    public void sendTechEmail(){
    	TechPomos techPomos = pomosMapper.selectNumOfTechPomos();
    	int numOfTechPomos = techPomos.getNumOfTechPomos();
    	
    	if (numOfTechPomos % 5 > 0) {
    		return;
    	}
    	
    	
    	CacheSingleton.getCacheSingleton();
    	if(CacheSingleton.getNumOfTechPomosSent() == numOfTechPomos) {
    		return;
    	} else {
    		CacheSingleton.setNumOfTechPomosSent(numOfTechPomos);
    	}
    	
    	String to = "levenyes@icloud.com";
        String title = "技术番茄数到达" + numOfTechPomos + "!";
        String statement = "结束番茄数到达" + numOfTechPomos + "!";
        StringBuilder content = new StringBuilder();
        for (int i=0; i < repeatTimes; i++) {
        	content.append(statement).append("\n");
        }
        mailService.sendSimpleMail(to, title, content.toString());
    }

	public void sendReadEmail(){
		ReadPomos readPomos = pomosMapper.selectNumOfReadPomos();
		int numOfReadPomos = readPomos.getNumOfReadPomos();

		if (numOfReadPomos % 5 > 0) {
			return;
		}


		CacheSingleton.getCacheSingleton();
		if(CacheSingleton.getNumOfReadPomosSent() == numOfReadPomos) {
			return;
		} else {
			CacheSingleton.setNumOfReadPomosSent(numOfReadPomos);
		}

		String to = "levenyes@icloud.com";
		String title = "阅读番茄数到达" + numOfReadPomos + "!";
		String statement = "阅读番茄数到达" + numOfReadPomos + "!";
		StringBuilder content = new StringBuilder();
		for (int i=0; i < repeatTimes; i++) {
			content.append(statement).append("\n");
		}
		mailService.sendSimpleMail(to, title, content.toString());
	}
    
}
