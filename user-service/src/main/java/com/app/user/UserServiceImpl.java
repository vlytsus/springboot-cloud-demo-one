package com.app.user;

import com.app.email.EmailService;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final EmailService emailService;
    private final UserRepository userRepository;

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
        Iterable<UserEntity> allUsers = userRepository.findAll();
        log.debug("getUsers: completed");
        return StreamSupport.stream(allUsers.spliterator(), false).collect(Collectors.toList());
    }

    @Override
    public UserEntity getUserById(UUID userId) {
        UserEntity user = userRepository.findById(userId).get();
        log.debug("getUserByUsername: ", user);
        return user;
    }
}
