package com.example.SpringBootTest.security;

import com.example.SpringBootTest.model.UserModel;
import com.example.SpringBootTest.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = userService.findUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("該帳號不存在");
        }
        return new CustomUserDetails(user);
    }
}
