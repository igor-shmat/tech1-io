package com.tech1io.service;


import com.tech1io.dao.AuthorizationRepository;
import com.tech1io.entity.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private AuthorizationRepository repository;
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Authorization myUser= repository.findByLogin(userName);
        if (myUser == null) {
            throw new UsernameNotFoundException("Unknown user: "+userName);
        }
        UserDetails user = User.builder()
                .username(myUser.getLogin())
                .password(myUser.getPassword())
                .roles(myUser.getRole().toString())
                .build();
        return user;
    }
}
