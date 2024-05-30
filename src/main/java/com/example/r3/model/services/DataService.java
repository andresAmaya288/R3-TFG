package com.example.r3.model.services;

import com.example.r3.model.entities.Problem;
import com.example.r3.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DataService {
    @Autowired
    ProblemService problemService;

    @Autowired
    UserService UserService;

    public Problem getProblem(long id) {
        return this.problemService.getProblem(id);
    }

    public Collection<Problem> getProblemValues(Sort sort) {
        return this.problemService.getValues(sort);
    }

    public Collection<Problem> getProblemValues() {
        return this.problemService.getValues();
    }

    public Problem addProblem(Problem problem) {
        return this.problemService.addProblem(problem);
    }

    public Problem updateProblem(Problem problem) {
        return this.problemService.updateProblem(problem);
    }


    public Problem deleteProblem(long id) {

        return this.problemService.deleteProblem(id);
    }

    public Problem deleteProblem(Problem problem) {
        return this.problemService.deleteProblem(problem);
    }
    ////////////////////////////////////////////////////////////////////
    public Collection<User> getUserValues(){
        return this.UserService.getValues();
    }

    public User getUser(String userName){
        User user = UserService.getUser(userName);
        return user;
    }

    public boolean containsUser(String userName){
        return this.UserService.containsUser(userName);
    }

    public boolean login (User user){
        return this.UserService.login(user);
    }

    public boolean login (String userName, String password){
        return this.UserService.login(userName,password);
    }

    public User addUser (User user){
        return this.UserService.addUser(user);
    }

    public User deleteUser (User user) {
        User deleted = this.UserService.deleteUser(user);
        return deleted;
    }

    public User updateUser(String username, String password){
        User user = this.UserService.getUser(username);
        if(user != null) {
            user.setHashedPassword(password);
            return this.UserService.updateUser(user);
        }else{
            return null;
        }
    }

    public User deleteUser (String username) {
        User deleted = this.UserService.deleteUser(username);
        return deleted;
    }
    //////////////////////////////////////////////

    public Problem solve(User user, Problem problem){
        return this.UserService.solve(user, problem);
    }
}