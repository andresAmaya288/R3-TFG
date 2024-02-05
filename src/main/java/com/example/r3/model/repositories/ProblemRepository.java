package com.example.r3.model.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.r3.model.entities.Problem;

public interface ProblemRepository extends JpaRepository <Problem, Long>{
}
