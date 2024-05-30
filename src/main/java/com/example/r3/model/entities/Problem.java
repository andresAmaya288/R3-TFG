package com.example.r3.model.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@NoArgsConstructor
@Entity
public class Problem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    String title;
    String statement;
    String code;
    String function;
    String args;
    String urlImg;

    String extraFunction1;
    String extraFunction2;
    int points;
    int difficulty;

    char[] emptyStars;
    char [] fullStars;

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    List<String> operations = new ArrayList<>();
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    List<String> conditions = new ArrayList<>();
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    List<String> upCodes = new ArrayList<>();
    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    List<String> downCodes = new ArrayList<>();


    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
    List<Solution> solutions = new ArrayList<>();



    /*
    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    private List<User> userList  = new ArrayList<>();
    */

    public Problem(String title, String statement, String function, String args, String urlImg,
                   int points, int difficulty, List<String> operations,
                   List<String> conditions, List<String> upCodes,
                   List<String> downCodes, List<Solution> solutions) {
        this.title = title;
        this.statement = statement;
        this.function = function;
        this.args = args;
        this.urlImg = urlImg;
        this.points = points;
        this.difficulty = difficulty;
        this.operations = operations;
        this.conditions = conditions;
        this.upCodes = upCodes;
        this.downCodes = downCodes;
        this.solutions = solutions;
        this.emptyStars = new char [5 - difficulty];
        this.fullStars = new char [difficulty];

    }

    public Problem(String title, String statement, String function, String args, String urlImg,
                   int points, int difficulty, List<String> operations,
                   List<String> conditions, List<String> upCodes,
                   List<String> downCodes, List<Solution> solutions,String extraFunction1, String extraFunction2) {
        this.title = title;
        this.statement = statement;
        this.function = function;
        this.args = args;
        this.urlImg = urlImg;
        this.points = points;
        this.difficulty = difficulty;
        this.operations = operations;
        this.conditions = conditions;
        this.upCodes = upCodes;
        this.downCodes = downCodes;
        this.solutions = solutions;
        this.emptyStars = new char [5 - difficulty];
        this.fullStars = new char [difficulty];
        this.extraFunction1 = extraFunction1;
        this.extraFunction2 = extraFunction2;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    /*
    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
    */
    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isSolution(Solution solution){
        return this.solutions.contains(solution);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public List<String> getOperations() {
        return operations;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    public List<String> getConditions() {
        return conditions;
    }

    public void setConditions(List<String> conditions) {
        this.conditions = conditions;
    }

    public List<String> getUpCodes() {
        return upCodes;
    }

    public void setUpCodes(List<String> upCodes) {
        this.upCodes = upCodes;
    }

    public List<String> getDownCodes() {
        return downCodes;
    }

    public void setDownCodes(List<String> downCodes) {
        this.downCodes = downCodes;
    }

    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public char[] getEmptyStars() {
        return emptyStars;
    }

    public void setEmptyStars(char[] emptyStars) {
        this.emptyStars = emptyStars;
    }

    public char[] getFullStars() {
        return fullStars;
    }

    public void setFullStars(char[] fullStars) {
        this.fullStars = fullStars;
    }

    public String getExtraFunction1() {
        return extraFunction1;
    }

    public void setExtraFunction1(String extraFunction1) {
        this.extraFunction1 = extraFunction1;
    }

    public String getExtraFunction2() {
        return extraFunction2;
    }

    public void setExtraFunction2(String extraFunction2) {
        this.extraFunction2 = extraFunction2;
    }

    public List<Solution> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Solution> solutions) {
        this.solutions = solutions;
    }

    @ManyToMany(mappedBy = "problemList")
    private Collection<User> users;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
