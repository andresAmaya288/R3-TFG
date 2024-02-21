package com.example.r3.model.entities;

import jakarta.persistence.*;

@Entity
public abstract class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

}
