package com.example.r3.model.services;

import com.example.r3.model.entities.Problem;
import com.example.r3.model.repositories.ProblemRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProblemService {

     @Autowired
    ProblemRepository problemRepository;


    public Problem getProblem(long id){

        Optional<Problem> op = this.problemRepository.findById(id);

        return op.orElse(null);
    }

    public Collection<Problem> getValues (Sort sort){
        return this.problemRepository.findAll(sort);
    }
    public Collection<Problem> getValues (){
        return  this.problemRepository.findAll();
    }
    public Problem addProblem(Problem problem){
        if (this.problemRepository.existsById(problem.getId())){
            return null;
        }else{
            problemRepository.save(problem);
            return problem;
        }
    }

    public Problem updateProblem(Problem problem){
        if (this.problemRepository.existsById(problem.getId())){
            return this.problemRepository.save(problem);
        }else{
            return null;
        }
    }


    public Problem deleteProblem (Problem problem){

        if(this.problemRepository.existsById(problem.getId())){
            problem = this.problemRepository.findById(problem.getId()).orElse(null);
            this.problemRepository.deleteById(problem.getId());
        }

        return problem;
    }

    public Problem deleteProblem (Long id){
        Problem problem = null;

        if(this.problemRepository.existsById(id)){
            problem = this.problemRepository.findById(id).orElse(null);
            this.problemRepository.deleteById(id);
        }

        return problem;
    }
}
