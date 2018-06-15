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
import cn.liwenye.service.SendMailService;

public class TaskPomotodoMail extends QuartzJobBean {

	@Autowired
	private PomosMapper pomosMapper;

	@Autowired
	private SendMailService sendMailService;

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
    	
    	String pomotodoName = "技术";
		int numOfPomotodo = numOfTechPomos;
		sendMailService.sendEmail(pomotodoName, numOfPomotodo);
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

		String pomotodoName = "阅读";
		int numOfPomotodo = numOfReadPomos;
		sendMailService.sendEmail(pomotodoName, numOfPomotodo);
	}

}
