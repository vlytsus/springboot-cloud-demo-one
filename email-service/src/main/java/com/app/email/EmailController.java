package com.app.email;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("email")
@RequiredArgsConstructor
public class EmailController {

    private final EmailService emailService;

    @RequestMapping("/verifyEmail/{userId}/{email}")
    void verifyEmail(@PathVariable("userId") UUID userId, @PathVariable("email") String email){
        emailService.verifyEmail(userId, email);
    }
}
