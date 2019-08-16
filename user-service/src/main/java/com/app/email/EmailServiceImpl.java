package com.app.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {

    @Autowired
    private MailSender mailSender;

    @Override
    public void verifyEmail(UUID userId, String email){
        log.debug("verifyEmail: ", email);

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("scg.victa@gmail.com");
        message.setSubject("test message from micro service");
        message.setText("Example message text");
//        mailSender.send(message);
    }
}
