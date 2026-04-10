package com.example.kfcglobaloperationsapp.Uzair_2521139;

public class User {

    protected int userID;
    protected String name, userName, passwd, role;

    public User(int userID, String name) {
        this.userID = userID;
        this.name = name;
    }

    public User(int userID, String name, String userName, String passwd, String role) {
        this.userID = userID;
        this.name = name;
        this.userName = userName;
        this.passwd = passwd;
        this.role = role;
    }
}
