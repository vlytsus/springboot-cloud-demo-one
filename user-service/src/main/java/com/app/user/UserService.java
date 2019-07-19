package com.app.user;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void saveUser(UserEntity user);
    List<UserEntity> getUsers();
    UserEntity getUserByUsername(String username);
    UserEntity getUserById(UUID userId);
}
