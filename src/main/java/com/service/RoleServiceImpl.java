package com.service;

import com.dao.RoleRepository;
import com.model.Role;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Max on 11.04.2017.
 */
@Service
public class RoleServiceImpl implements RoleService {
    private static final Logger LOG = LoggerFactory.getLogger(RoleServiceImpl.class);

    @Autowired
    private RoleRepository repository;

    @Override
    public Role getRoleById(int id) {
        LOG.info("findRoleById (ROLES)");
        return repository.findRoleById(id);
    }

    @Override
    public List<Role> findAll() {
        LOG.info("findAll (ROLES)");
        return repository.findAll();
    }

    @Override
    public void removeById(int id) {
        LOG.info("removeById (ROLES)");
        repository.deleteById(id);
    }

    @Override
    public void saveRole(Role role) {
        LOG.info("saveRole (ROLES)");
        repository.save(role);
    }
}
