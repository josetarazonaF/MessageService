package com.globant.MessageService.auth.payload.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String username;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    private String name;
    private String lastName;
    private String identificationNumber;
    private String address;
    private String zipCodeCity;
    private String state;
    private String country;

    private Set<String> role;


}