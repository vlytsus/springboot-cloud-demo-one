package com.app.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Override
    public void verifyEmail(UUID userId, String email){
        log.debug("verifyEmail: ", email);
    }
}
