package com.dao;

import com.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Max on 11.04.2017.
 */
@Repository
@Transactional
public interface RoleRepository extends CrudRepository<Role, Integer> {

    Role findRoleById(int id);

    List<Role> findAll();

    void deleteById(int id);
}
