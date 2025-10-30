package org.varun.springsecjwt.service;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.varun.springsecjwt.dao.UserRepo;
import org.varun.springsecjwt.model.User;
import org.varun.springsecjwt.model.UserPrincipal;

@Service
@AllArgsConstructor
public class MyUserDetailsService implements UserDetailsService {
    private UserRepo repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=repo.findUserByUserName(username);
        if(user==null){
            System.out.println("User not found 404");
            throw new UsernameNotFoundException("User Not Found 404");
        }
        return new UserPrincipal(user);
    }
}
