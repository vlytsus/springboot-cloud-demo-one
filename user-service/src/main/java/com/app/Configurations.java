package com.app;

import com.app.email.EmailService;
import com.app.email.EmailServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Slf4j
@Configuration
@PropertySource("classpath:application.properties")
//@ConfigurationProperties(prefix="spring.mail")
public class Configurations {

    @Autowired
    @Value("${spring.mail.username}")
    private String username;

//    public void setUsername(String username) {
//        this.username = username;
//    }

    @Autowired
    @Value("${spring.mail.password}")
    private String password;

//    public void setPassword(String password) {
//        this.password = password;
//    }

    @Autowired
    @Value("${spring.mail.host}")
    private String host;

//    public void setHost(String host) {
//        this.host = host;
//    }


    @Autowired
    @Value("${spring.mail.port}")
    private int port;
//    public void setPort(int port) {
//        this.port = port;
//    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();

        mailSender.setHost(host);
        mailSender.setPort(port);
        mailSender.setUsername(username);
        mailSender.setPassword(password);

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }

}
