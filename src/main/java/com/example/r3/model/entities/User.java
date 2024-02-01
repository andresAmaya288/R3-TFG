package com.example.r3.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.SecureRandom;

@NoArgsConstructor
@Entity
public class User {
    @Id
    String username;

    @Transient
    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

    @Column(nullable = true)
    private String hashedPassword;

}
