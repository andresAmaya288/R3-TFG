package com.example.r3.model.services;

import org.springframework.stereotype.Service;

@Service
public class UserService {
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

        if(this.userRepository.existsById(user.getUserName())) {
            return this.userRepository.findById(user.getUserName()).orElse(null).samePassword(user);
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
        if(this.userRepository.existsById(user.getUserName())){
            return null;
        }else {
            this.userRepository.save(user);
            return user;
        }
    }

    public User deleteUser (User user) {
        User result;
        if (!this.userRepository.existsById(user.getUserName())) {
            result = null;
        } else {
            this.userRepository.deleteById(user.getUserName());
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
}
