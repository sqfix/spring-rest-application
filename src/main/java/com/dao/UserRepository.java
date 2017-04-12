package com.dao;

import com.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Max on 11.04.2017.
 */
@Repository
@Transactional
public interface UserRepository extends CrudRepository<User, Integer> {

    User getUserById(int id);

    List<User> findAll();

    void removeUserById(int id);

    User findUserByUserName(String userName);
}
