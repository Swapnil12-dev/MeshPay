package com.mesh.dto;

public class LoginResponse {

    private String name;
    private String vpa;

    public LoginResponse() {
    }

    public LoginResponse(String name, String vpa) {
        this.name = name;
        this.vpa = vpa;
    }

    public String getName() {
        return name;
    }

    public String getVpa() {
        return vpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVpa(String vpa) {
        this.vpa = vpa;
    }
}