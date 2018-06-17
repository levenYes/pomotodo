package cn.liwenye.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private Log logger = LogFactory.getLog(MailService.class);


    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    private JavaMailSender sender;

    public void sendSimpleMail(String to, String title, String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(title);
        message.setText(content);
        sender.send(message);
        logger.info("邮件发送成功");
    }
}