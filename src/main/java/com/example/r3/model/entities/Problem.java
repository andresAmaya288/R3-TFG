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
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String statement;
    String code;
    List<Case> answer = new ArrayList<>();


    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    private List<User> userList  = new ArrayList<>();


}
