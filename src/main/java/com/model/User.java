package com.model;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Max on 08.04.2017.
 */
@Entity
@Table(name = "user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column(name = "name")
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "isActive")
    private boolean isActive;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<Role> roles;

    public User() {
    }

    public User(String userName, String passWord, boolean isActive, Set<Role> roles) {
        this.userName = userName;
        this.passWord = passWord;
        this.isActive = isActive;
        this.roles = roles;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "id " + id +
                ", userName " + userName +
                ", passWord " + passWord +
                ", isActive " + isActive +
                ", roles " + roles + "\n";
    }
}
