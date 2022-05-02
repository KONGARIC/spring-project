package com.luv2code.springboot.AssignmentDemo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "username")
    @NotNull(message = "please enter")
    private String username;

    @Column(name = "password")
    @NotNull(message = "please enter")
    private String password;

    @Column(name = "id")
    @NotNull(message = "please enter")
    private int id;

    @Column(name = "enabled")
    @NotNull(message = "please enter")
    private int enabled=1;

    public User(){}

    public User(String username, String password, int id, int enabled) {
        this.username = username;
        this.password = password;
        this.id = id;
        this.enabled = enabled;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }
}
