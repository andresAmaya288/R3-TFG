package com.example.r3.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@NoArgsConstructor
@Entity
public class Problem {
    @Id
    int id;
    @Transient
    @Autowired
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

    @Column(nullable = true)
    @JsonView(Token.Basic.class)
    @JsonIgnore
    private String hashedPassword;

}
