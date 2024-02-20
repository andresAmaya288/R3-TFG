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
    List<Condition> answer = new ArrayList<>();

    @ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH})
    private List<User> userList  = new ArrayList<>();

    public Problem(String title, String statement, String code, int difficulty, int points, List<Condition> answer) {
        this.statement = statement;
        this.code = code;
        this.difficulty = difficulty;
        this.answer = answer;
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

    public List<Condition> getAnswer() {
        return answer;
    }

    public void setAnswer(List<Condition> answer) {
        this.answer = answer;
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

    public boolean isSolution(List<Condition> solution){
        boolean sol = new HashSet<>(this.answer).containsAll(solution) && this.answer.size() == solution.size();
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
