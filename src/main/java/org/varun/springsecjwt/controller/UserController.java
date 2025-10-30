package org.varun.springsecjwt.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.varun.springsecjwt.model.User;
import org.varun.springsecjwt.service.UserService;

@RestController
@AllArgsConstructor
public class UserController {
    private UserService service;
    private AuthenticationManager authenticationManager;

    @PostMapping("register")
    public User register(@RequestBody User user){
        return service.addUser(user);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUserName(),user.getPassword()));
        if(authentication.isAuthenticated()) return "Success";
        else return "Failed";
    }
}
