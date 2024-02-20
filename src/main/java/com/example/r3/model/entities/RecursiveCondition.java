package com.example.r3.model.entities;

import java.util.Objects;

public class RecursiveCondition extends Condition {
    String downCode;
    String upCode;

    public RecursiveCondition(String downCode, String upCode) {
        this.downCode = downCode;
        this.upCode = upCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecursiveCondition that = (RecursiveCondition) o;
        return Objects.equals(downCode, that.downCode) && Objects.equals(upCode, that.upCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(downCode, upCode);
    }
}
