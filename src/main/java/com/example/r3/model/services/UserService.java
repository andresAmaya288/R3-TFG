package com.example.r3.model.services;

import com.example.r3.model.entities.Problem;
import com.example.r3.model.entities.User;
import com.example.r3.model.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Collection<User> getValues(){
        return this.userRepository.findAll();
    }

    public User getUser(String userName){
        User user = this.userRepository.findById(userName).orElse(null);
        return user;
    }

    public boolean containsUser(String userName){
        return this.userRepository.existsById(userName);
    }

    public boolean login (User user){

        if(this.userRepository.existsById(user.getUsername())) {
            return this.userRepository.findById(user.getUsername()).orElse(null).samePassword(user);
        }else{
            return false;
        }
    }

    public boolean login (String userName, String password){
        if(this.userRepository.existsById(userName)) {
            return this.userRepository.findById(userName).orElse(null).samePassword(password);
        }else{
            return false;
        }
    }

    public User addUser (User user){
        if(this.userRepository.existsById(user.getUsername())){
            return null;
        }else {
            this.userRepository.save(user);
            return user;
        }
    }

    public User deleteUser (User user) {
        User result;
        if (!this.userRepository.existsById(user.getUsername())) {
            result = null;
        } else {
            this.userRepository.deleteById(user.getUsername());
            result = user;
        }
        return result;
    }

    public User deleteUser (String username) {
        User result;
        if (!this.userRepository.existsById(username)) {
            result = null;
        } else {
            result = this.userRepository.findById(username).orElse(null);
            this.userRepository.deleteById(username);
        }
        return result;
    }

    public User updateUser(User user){
        return this.userRepository.save(user);
    }

    @Transactional
    public Problem solve(User user, Problem problem){
        user = this.userRepository.findByUsername(user.getUsername()).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        user.addProblem(problem);
        this.updateUser(user);
        return problem;
    }
}
