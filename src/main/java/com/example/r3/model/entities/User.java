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
@Table(name="`user`")
public class User {
    @Id
    String username;
    @Transient
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
    @Column(nullable = true)
    private String hashedPassword;
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    private List<Problem> problemList  = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles;

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public List<Problem> getProblemList() {
        return problemList;
    }

    public void setProblemList(List<Problem> problemList) {
        this.problemList = problemList;
    }



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

    public User(String username, String password, String ... roles) {
        this.username = username;
        if (password != null) {
            this.hashedPassword = passwordEncoder.encode(password);
        }
        this.roles = List.of(roles);
    }

    public Problem addProblem(Problem problem){
       Boolean foo = this.problemList.add(problem);
       return foo?problem:null;
    }

    public boolean samePassword(User user){
        return this.hashedPassword == user.hashedPassword;
    }

    public boolean samePassword(String password){
        return this.hashedPassword.equals(passwordEncoder.encode(password));
    }

    public List<String> getRoles() {
        return roles;
    }


}
