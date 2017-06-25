package com.codingeye.tm.pojo;

/**
 * Created by Camon on 2017/6/25.
 */
public class User {
    private String username;
    private String type;

    public User(){}

    public User(String username, String type) {
        this.username = username;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
