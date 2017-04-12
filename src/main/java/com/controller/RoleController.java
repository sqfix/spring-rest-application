package com.controller;

import com.model.Role;
import com.model.User;
import com.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

/**
 * Created by Max on 11.04.2017.
 */
@RestController
public class RoleController {

    @Autowired
    private RoleService service;

    @RequestMapping(value = "/addR", method = RequestMethod.POST)
    private void addRole(@RequestBody Role role) {
        service.saveRole(role);
    }

    private void updateRole(@PathVariable int id, @RequestBody Role role) {
        throw new RuntimeException("STUB");
    }

    @RequestMapping(value = "/removeR{id}", method = RequestMethod.DELETE)
    private void removeRole(@PathVariable int id) {
        service.removeById(id);
    }

    @RequestMapping(value = "/getR{id}", method = RequestMethod.GET)
    private Role getRoleById(@PathVariable int id) {
        return service.getRoleById(id);
    }

    @RequestMapping(value = "/getAllR", method = RequestMethod.GET)
    private List<Role> roleList() {
        return service.findAll();
    }
}
