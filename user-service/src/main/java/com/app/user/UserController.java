package com.app.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping(path = "/")
    public void createUser(@RequestBody UserEntity user){
        userService.saveUser(user);
    }

    @GetMapping(path = "/")
    public List<UserEntity> getUsers(){
        return userService.getUsers();
    }

    @GetMapping(path = "/username/{username}")
    public UserEntity getUserEntityByEmail(@PathVariable("username") String username){
        return userService.getUserByUsername(username);
    }

    @GetMapping(path = "/id/{uid}")
    public UserEntity getUserEntityByUid(@PathVariable("uid") String uid){
        return userService.getUserById(UUID.fromString(uid));
    }
}
