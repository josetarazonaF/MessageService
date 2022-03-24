package com.globant.MessageService.auth.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "users",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "username")
        })
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String name;
    private String lastName;
    private String identificationNumber;
    private String address;
    private String zipCodeCity;
    private String state;
    private String country;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    public User(String username, String name, String lastName, String identificationNumber,
                String address, String zipCodeCity, String state, String country, String password) {
        this.username = username;
        this.name = name;
        this.lastName = lastName;
        this.identificationNumber = identificationNumber;
        this.address = address;
        this.zipCodeCity = zipCodeCity;
        this.state = state;
        this.country = country;
        this.password = password;


    }

}