package com.luv2code.springboot.AssignmentDemo.service.serviceImpl.AssignmentDemo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "authorities")
public class Authority {
    @Id
    @Column(name = "username")
    @NotNull(message = "please enter")
    private String username;

    @Column(name = "authority")
    @NotNull(message = "please enter")
    private String authority;
    @Column(name = "id")
    @NotNull(message = "please enter")
    private int id;

    public Authority(String username, String authority, int id) {
        this.username = username;
        this.authority = authority;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Authority(){}

    public Authority(String username, String authority) {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
