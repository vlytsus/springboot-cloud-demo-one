package com.app.user;

import com.app.email.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        emailService.verifyEmail(user.getId(), user.getUsername());
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
    public UserEntity getUserByUid(Long uid) {
        UserEntity user = userRepository.findById(uid).get();
        log.debug("getUserByUsername: ", user);
        return user;
    }
}
