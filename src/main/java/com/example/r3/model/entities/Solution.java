package com.example.r3.model.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NoArgsConstructor
public class Solution {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
    List<BaseCondition> baseAnswer = new ArrayList<>();
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE,CascadeType.DETACH,CascadeType.REMOVE})
    List<RecursiveCondition> recursiveAnswer = new ArrayList<>();

    public Solution(List<BaseCondition> baseAnswer, List<RecursiveCondition> recursiveAnswer) {
        this.baseAnswer = baseAnswer;
        this.recursiveAnswer = recursiveAnswer;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solution solution = (Solution) o;
        return Objects.equals(baseAnswer, solution.baseAnswer) && Objects.equals(recursiveAnswer, solution.recursiveAnswer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseAnswer, recursiveAnswer);
    }
}
