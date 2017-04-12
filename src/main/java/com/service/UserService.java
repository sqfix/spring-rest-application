package com.service;

import com.model.User;

import java.util.List;

/**
 * Created by Max on 11.04.2017.
 */
public interface UserService {
    User getUserById(int id);

    List<User> getAll();

    void removeUserById(int id);

    void saveUser(User user);
}
