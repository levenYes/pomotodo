package cn.liwenye.schedule;

import cn.liwenye.bean.ReadPomos;

import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import cn.liwenye.bean.TechPomos;
import cn.liwenye.cache.CacheSingleton;
import cn.liwenye.dao.PomosMapper;
import cn.liwenye.service.SendMailService;

/**
 * @author liwenye
 */
public class TaskPomotodoMail extends QuartzJobBean {

	@Autowired
	private PomosMapper pomosMapper;

	@Autowired
	private SendMailService sendMailService;

	public static int HOW_MANY_POMOS_ALERT = 5;
	
	public static int TECH_BEGIN_TOALERT = 500;
	
	public static int READ_BEGIN_TOALERT = 1700;

    @Override
    protected void executeInternal(JobExecutionContext context) {
		sendTechEmail();
		sendReadEmail();
    }

    public void sendTechEmail(){
    	TechPomos techPomos = pomosMapper.selectNumOfTechPomos();
    	int numOfTechPomos = techPomos.getNumOfTechPomos();
    	
    	if (numOfTechPomos % HOW_MANY_POMOS_ALERT > 0
                || CacheSingleton.getNumOfTechPomosSent() == numOfTechPomos
                || numOfTechPomos < TECH_BEGIN_TOALERT) {
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

		if (numOfReadPomos % HOW_MANY_POMOS_ALERT > 0
                || CacheSingleton.getNumOfReadPomosSent() == numOfReadPomos
                || numOfReadPomos < READ_BEGIN_TOALERT) {
			return;
		} else {
			CacheSingleton.setNumOfReadPomosSent(numOfReadPomos);
		}

		String pomotodoName = "阅读";
		int numOfPomotodo = numOfReadPomos;
		sendMailService.sendEmail(pomotodoName, numOfPomotodo);
	}

}
