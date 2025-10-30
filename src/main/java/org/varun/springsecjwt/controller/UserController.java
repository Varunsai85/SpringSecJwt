package org.varun.springsecjwt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.varun.springsecjwt.model.User;
import org.varun.springsecjwt.sevice.UserService;

@RestController
public class UserController {
    private UserService service;

    @PostMapping("register")
    public User register(@RequestBody User user){
        return service.addUser(user);
    }
}
