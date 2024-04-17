package com.example.r3.model.entities;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@NoArgsConstructor
public class BaseCondition extends Condition {
    String condition;
    String operation;

    int num = -1;

    public BaseCondition(String condition, String operation) {
        this.condition = condition;
        this.operation = operation;
    }

    public BaseCondition(String condition, String operation, int num) {
        this.condition = condition;
        this.operation = operation;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseCondition baseCase = (BaseCondition) o;
        return Objects.equals(condition, baseCase.condition) && Objects.equals(operation, baseCase.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, operation);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
