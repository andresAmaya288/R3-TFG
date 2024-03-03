package com.example.r3.controller;

import com.example.r3.model.entities.BaseCondition;
import com.example.r3.model.entities.Problem;
import com.example.r3.model.entities.RecursiveCondition;
import com.example.r3.model.services.DataService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class R3RestController {
    @Autowired
    DataService dataService;
    @Autowired
    EntityManager entityManager;

    @PostMapping("/problem/{id}/solution")
    public ResponseEntity<Boolean> solution (
            HttpServletRequest request,
            @PathVariable String id,
            @RequestBody Map<String, String> requestBody){

        String condition = requestBody.get("condition");
        String operation = requestBody.get("operation");
        String upCode = requestBody.get("upCode");
        String downCode = requestBody.get("downCode");

        Long idLong = Long.parseLong(id);
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();
        recursiveAnswer.add(new RecursiveCondition(downCode, upCode));
        baseAnswer.add(new BaseCondition(condition, operation));
        Problem problem = this.dataService.getProblem(idLong);
        if(problem != null) {
            boolean bool = problem.isSolution(baseAnswer, recursiveAnswer);
            return new ResponseEntity<>(bool, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}
