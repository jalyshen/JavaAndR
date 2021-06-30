package org.jaly.cauc.api.dto;

public class LoginRequest {

    public String userName;
    public String passwordMd5;

    public LoginRequest(){}
    public LoginRequest(String userName, String passwordMd5) {
        this.userName = userName;
        this.passwordMd5 = passwordMd5;
    }
}
