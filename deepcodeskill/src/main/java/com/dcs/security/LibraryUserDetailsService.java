package com.dcs.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.dcs.dao.IUserDAO;



@Component
public class LibraryUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserDAO dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return dao.findByEmail(username)
                .map(LibraryUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("No user found"));
    }
}