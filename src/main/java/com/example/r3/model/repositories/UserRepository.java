package com.example.r3.model.repositories;

import com.example.r3.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String> {
    Optional<User> findByUserName(String name);
}
