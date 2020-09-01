package com.qrdemo.controllers.model;

public class UserAuthenticationRequest {
    private final String userName;
    private final String password;

    public UserAuthenticationRequest(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
