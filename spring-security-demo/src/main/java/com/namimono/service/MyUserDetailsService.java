package com.namimono.service;

import com.namimono.bean.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService {
//   真正的登陆操作需要在MyUserDetailsService进行

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        return new User("aaa","114514");
    }
}
