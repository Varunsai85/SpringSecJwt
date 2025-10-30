package org.varun.springsecjwt.service;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.varun.springsecjwt.dao.UserRepo;
import org.varun.springsecjwt.model.User;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepo repo;
    private BCryptPasswordEncoder encoder;

    public User addUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return repo.save(user);
    }
}
