package com.app.user;

import com.app.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private EmailService emailService;
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, EmailService emailservice){
        this.emailService = emailservice;
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(UserEntity user) {
        log.debug("saveUser: ", user);
        user = userRepository.save(user);
        emailService.verifyEmail(user.getUserId(), user.getUsername());
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        UserEntity user = userRepository.findByUsername(username);
        log.debug("getUserByUsername: ", user);
        return user;
    }

    @Override
    public List<UserEntity> getUsers() {
        List<UserEntity> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public UserEntity getUserById(UUID userId) {
        UserEntity user = userRepository.findById(userId).get();
        log.debug("getUserByUsername: ", user);
        return user;
    }
}
