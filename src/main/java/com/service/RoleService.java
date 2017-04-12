package com.service;

import com.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Max on 11.04.2017.
 */
public interface RoleService {
    Role getRoleById(int id);

    List<Role> findAll();

    void removeById(int id);

    void saveRole(Role role);
}
