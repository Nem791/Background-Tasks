package com.example.simplebackgroundtask;

public class User {
    public Integer id;
    public String name;
    public String email;
    public String gender;
    public String status;

    public User(String name, String email, String gender, String status) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.status = status;
    }
}
