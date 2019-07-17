package com.app.user;

import java.util.List;

public interface UserService {
    void saveUser(UserEntity user);
    List<UserEntity> getUsers();
    UserEntity getUserByUsername(String username);
    UserEntity getUserByUid(Long uid);
}
