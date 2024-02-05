package com.example.r3.model.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class User {
    @Id
    String username;
    @Transient
    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    @Column(nullable = true)
    private String hashedPassword;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    private List<Problem> problemList  = new ArrayList<>();

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public User(String userName, String password, String ... roles) {
        this.username = userName;
        if (password != null) {
            this.hashedPassword = passwordEncoder.encode(password);
        }
        this.roles = List.of(roles);
    }
    public List<String> getRoles() {
        return roles;
    }


}
