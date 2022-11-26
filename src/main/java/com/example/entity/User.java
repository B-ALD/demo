package com.example.entity;

import lombok.Data;


/**
 * @author lyl04
 */
@Data
public class User {

    private String name;
    private String id;
    private String address;
    private String tel;

    public User(String name, String id, String address, String tel) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.tel = tel;
    }

    public User() {
    }
}
