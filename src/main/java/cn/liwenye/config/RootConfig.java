package cn.liwenye.config;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

/**
 * @author liwenye
 */
public class RootConfig {
    /**
     * 配置邮件发送器
     * @return
     */
    @Bean
    public MailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.qq.com");
        mailSender.setPort(25);
        mailSender.setUsername("levenyes@qq.com");
        mailSender.setPassword("ywhmmdutkrklbhgc");
        return mailSender;
    }
}