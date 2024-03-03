package com.example.r3.model.services;

import com.example.r3.model.entities.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class DataService {
    @Autowired
    ProblemService problemService;
    /*
    @Autowired
    UserService userService;
    */
    public Problem getProblem(long id) {
        return this.problemService.getProblem(id);
    }

    public Collection<Problem> getProblemValues(Sort sort) {
        return this.problemService.getValues(sort);
    }

    public Collection<Problem> getProblemValues() {
        return this.problemService.getValues();
    }

    public Problem addProblem(Problem problem) {
        return this.problemService.addProblem(problem);
    }

    public Problem updateProblem(Problem problem) {
        return this.problemService.updateProblem(problem);
    }


    public Problem deleteProblem(long id) {

        return this.problemService.deleteProblem(id);
    }

    public Problem deleteProblem(Problem problem) {
        return this.problemService.deleteProblem(problem);
    }

}