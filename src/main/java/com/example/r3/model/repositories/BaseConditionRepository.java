package com.example.r3.model.repositories;

import com.example.r3.model.entities.BaseCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaseConditionRepository extends JpaRepository<BaseCondition, Long>{
}

