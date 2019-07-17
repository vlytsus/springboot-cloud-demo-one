package com.app.email;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class EmailServiceImpl implements EmailService {
    @Override
    public void verifyEmail(Long userId, String email){
      log.debug("verifyEmail: ", email);
    }
}
