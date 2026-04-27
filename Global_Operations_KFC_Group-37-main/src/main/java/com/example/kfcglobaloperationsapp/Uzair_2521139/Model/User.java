package com.example.kfcglobaloperationsapp.Uzair_2521139.Model;

public abstract class  User {

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

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRole() {
        return role;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
