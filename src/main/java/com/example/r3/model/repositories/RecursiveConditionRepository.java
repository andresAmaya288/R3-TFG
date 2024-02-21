package com.example.r3.model.repositories;


import com.example.r3.model.entities.Problem;
import com.example.r3.model.entities.RecursiveCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursiveConditionRepository extends JpaRepository<RecursiveCondition, Long>{
}

