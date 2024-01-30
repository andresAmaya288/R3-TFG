package com.example.r3.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class User {
    @Id
    String username;

}
