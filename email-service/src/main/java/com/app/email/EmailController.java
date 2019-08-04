package com.app.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("email")
public class EmailController {
    private EmailService emailService;

    @Autowired
    public void EmailController(EmailService emailService){
        this.emailService = emailService;
    }

    @RequestMapping("/verifyEmail/{userId}/{email}")
    void verifyEmail(@PathVariable("userId") UUID userId, @PathVariable("email") String email){
        emailService.verifyEmail(userId, email);
    }
}
