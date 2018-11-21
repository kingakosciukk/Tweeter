package com.coderslab.entity;

import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;

@Entity
@Table(name = "tweeter_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @Email
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade	= CascadeType.ALL)
    private Collection<Tweet> tweats;

    public User() {
    }

    public User(@NotNull String firstName, @NotNull String lastName, @Email String email, Collection<Tweet> tweats) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.tweats = tweats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getShow() {
        return this.firstName + this.lastName;
    }
}