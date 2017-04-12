package com.service;


import com.dao.UserRepository;
import com.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Max on 12.04.2017.
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    private static final Logger LOG = LoggerFactory.getLogger(UserDetailServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByUserName(username);
        LOG.info("LOGINED BY " + user);
        return new org.springframework.security.core.userdetails.User(
                user.getUserName(), user.getPassWord(), grantedAuthorities(user));
    }

    private Set<GrantedAuthority> grantedAuthorities(User user) {
        return new HashSet<GrantedAuthority>() {{
            user.getRoles().forEach(r -> add(new SimpleGrantedAuthority(r.getName())));
        }};
    }
}
