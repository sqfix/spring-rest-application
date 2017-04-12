package com.service;

import com.dao.UserRepository;
import com.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Max on 11.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {
    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserRepository repository;

    @Override
    public User getUserById(int id) {
        LOG.info("getUserById (USER)");
        return repository.getUserById(id);
    }

    @Override
    public List<User> getAll() {
        LOG.info("getAll (USER)");
        return repository.findAll();
    }

    @Override
    public void removeUserById(int id) {
        LOG.info("removeUserById (USER)");
        repository.removeUserById(id);
    }

    @Override
    public void saveUser(User user) {
        LOG.info("saveUser (USER)");
        user.setPassWord(new BCryptPasswordEncoder().encode(user.getPassWord()));
        LOG.debug("pass encoded: " + user.getPassWord());
        repository.save(user);
    }
}
