package com.example.r3.model.entities;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public abstract class Condition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;

}


