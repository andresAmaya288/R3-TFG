package com.example.r3.model.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
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
    int points;
    int difficulty;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
    List<BaseCondition> baseAnswer = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
    List<RecursiveCondition> recursiveAnswer = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    private List<User> userList  = new ArrayList<>();

    public Problem(String title, String statement, String code, int difficulty, int points, List<BaseCondition> baseAnswer, List<RecursiveCondition> recursiveAnswer) {
        this.statement = statement;
        this.code = code;
        this.difficulty = difficulty;
        this.baseAnswer = baseAnswer;
        this.recursiveAnswer = recursiveAnswer;
        this.difficulty = difficulty;
        this.title = title;
        this.points = points;
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

    public List<BaseCondition> getBaseAnswer() {
        return baseAnswer;
    }

    public void setBaseAnswer(List<BaseCondition> baseAnswer) {
        this.baseAnswer = baseAnswer;
    }

    public List<RecursiveCondition> getRecursiveAnswer() {
        return recursiveAnswer;
    }

    public void setRecursiveAnswer(List<RecursiveCondition> recursiveAnswer) {
        this.recursiveAnswer = recursiveAnswer;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isSolution(List<BaseCondition> baseAnswer,List<RecursiveCondition> recursiveAnswer ){
        Boolean sol = true;
        for (BaseCondition condition : baseAnswer){
            sol &= this.baseAnswer.contains(condition);
        }
        for (RecursiveCondition condition : recursiveAnswer){
            sol &= this.recursiveAnswer.contains(condition);
        }

        return sol;
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
}
