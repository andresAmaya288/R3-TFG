package com.example.r3.model.entities;

import java.util.Objects;

public class BaseCase implements Case {
    String condition;
    String operation;

    public BaseCase(String condition, String operation) {
        this.condition = condition;
        this.operation = operation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseCase baseCase = (BaseCase) o;
        return Objects.equals(condition, baseCase.condition) && Objects.equals(operation, baseCase.operation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, operation);
    }
}
