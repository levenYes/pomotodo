package cn.liwenye.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendMailService {
	@Autowired
    private MailService mailService;
	
	private static int repeatTimes = 10;
	
	public void sendEmail(String pomotodoName, int numOfPomotodo) {
		String to = "levenyes@icloud.com";
		String title = pomotodoName + "番茄数积累提醒！！！";
		String statement = pomotodoName + "番茄数到达" + numOfPomotodo + "！";
		StringBuilder content = new StringBuilder();
		for (int i=0; i < repeatTimes; i++) {
			content.append(statement).append("\n");
		}
		mailService.sendSimpleMail(to, title, content.toString());
	}
}
