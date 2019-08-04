package com.app.email;

import java.util.UUID;

public interface EmailService {
    void verifyEmail(UUID userId, String email);
}
