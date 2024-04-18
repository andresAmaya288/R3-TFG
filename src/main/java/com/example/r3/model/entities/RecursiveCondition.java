package com.example.r3.model.entities;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Entity
@NoArgsConstructor
public class RecursiveCondition extends Condition {
    String downCode;
    String upCode;
    String condition;

    int num = -1;

    public RecursiveCondition(String downCode, String upCode) {
        this.downCode = downCode;
        this.upCode = upCode;
    }

    public RecursiveCondition(String downCode, String upCode, String condition) {
        this.downCode = downCode;
        this.upCode = upCode;
        this.condition = condition;
    }

    public RecursiveCondition(String downCode, String upCode, String condition, int num) {
        this.downCode = downCode;
        this.upCode = upCode;
        this.condition = condition;
        this.num = num;
    }

    public RecursiveCondition(String downCode, String upCode, int num) {
        this.downCode = downCode;
        this.upCode = upCode;
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursiveCondition that = (RecursiveCondition) o;
        return Objects.equals(downCode, that.downCode) && Objects.equals(upCode, that.upCode) && Objects.equals(condition, that.condition);
    }

    @Override
    public int hashCode() {
        return Objects.hash(downCode, upCode, condition);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
