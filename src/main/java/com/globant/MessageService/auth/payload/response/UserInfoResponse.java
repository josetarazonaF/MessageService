package com.globant.MessageService.auth.payload.response;

import java.util.List;

public class UserInfoResponse {
    private Long id;
    private String username;
    private String name;
    private String lastName;
    private String identificationNumber;
    private String address;
    private String zipCodeCity;
    private String state;
    private String country;
    private List<String> roles;

    public UserInfoResponse(Long id, String username, String name, String lastName, String identificationNumber,
                            String address, String zipCodeCity, String state, String country, List<String> roles) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.address = address;
        this.zipCodeCity = zipCodeCity;
        this.state = state;
        this.country = country;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getRoles() {
        return roles;
    }
}