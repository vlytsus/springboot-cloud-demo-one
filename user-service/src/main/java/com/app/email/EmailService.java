package com.app.email;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@FeignClient(name="email-service" )
public interface EmailService {

    @RequestMapping("/email/verifyEmail/{userId}/{email}")
    void verifyEmail(@PathVariable("userId") UUID userId, @PathVariable("email") String email);
}
