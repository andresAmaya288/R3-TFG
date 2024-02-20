package com.example.r3.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public abstract class cond {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
}
