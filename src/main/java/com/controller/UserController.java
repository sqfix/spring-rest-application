package com.controller;

import com.model.Role;
import com.model.User;
import com.service.RoleService;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Max on 08.04.2017.
 */
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String authorize() {
        return userList().toString();
    }

    @RequestMapping(value = "/addU", method = RequestMethod.POST)
    private void addUser(@RequestBody User user) {
        service.saveUser(user);
    }

    private void updateUser(@PathVariable int id, @RequestBody User user) {
        throw new RuntimeException("STUB");
    }

    @RequestMapping(value = "/removeU{id}", method = RequestMethod.DELETE)
    private void removeUser(@PathVariable int id) {
        service.removeUserById(id);
    }

    @RequestMapping(value = "/getU{id}", method = RequestMethod.GET)
    private User getUserById(@PathVariable int id) {
        return service.getUserById(id);
    }

    @RequestMapping(value = "/getAllU", method = RequestMethod.GET)
    private List<User> userList() {
        return service.getAll();
    }

    //INSERT TEST DATA METHOD
    @RequestMapping(value = "/init2", method = RequestMethod.GET)
    private String testInit() {
        User alex = new User("Alex", "pass", false, Collections.emptySet());
        User max = new User("Max", "pass1", false, Collections.emptySet());
        User ann = new User("Ann", "pasw1", false, Collections.emptySet());

        Role roleAlex = new Role(alex, "USER");
        Role roleMax = new Role(max, "ADMIN");
        Role roleAnn = new Role(ann, "USER");
        Role roleAnn1 = new Role(ann, "ADMIN");

        alex.setRoles(new HashSet<Role>() {{
            add(roleAlex);
        }});
        max.setRoles(new HashSet<Role>() {{
            add(roleMax);
        }});
        ann.setRoles(new HashSet<Role>() {{
            add(roleAnn);
            add(roleAnn1);
        }});

        service.saveUser(alex);
        service.saveUser(max);
        service.saveUser(ann);

        return "OK";
    }

    //FOR A TEST
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    private String admin(){
        return "ADMIN LOGINED";
    }
}
