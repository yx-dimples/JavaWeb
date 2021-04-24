package com.login.user;

public class User {
    private int id = 0 ;
    private String username = null;
    private String password = null;

    public User(String username,String password) {
        this.username = username;
        this.password = password;
    }
    public User(){

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
}
