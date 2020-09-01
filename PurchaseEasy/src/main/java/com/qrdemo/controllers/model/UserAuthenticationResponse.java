package com.qrdemo.controllers.model;

public class UserAuthenticationResponse {

    private String jwt;

    public UserAuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
