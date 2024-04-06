package com.example.r3.controller;

import com.example.r3.model.entities.BaseCondition;
import com.example.r3.model.entities.Problem;
import com.example.r3.model.entities.RecursiveCondition;
import com.example.r3.model.services.DataService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
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
            @RequestBody Map<String, ArrayList<String> > requestBody){

        ArrayList<String> conditions = requestBody.get("conditions");
        ArrayList<String> operations = requestBody.get("operations");
        ArrayList<String> upCodes = requestBody.get("upCodes");
        ArrayList<String> downCodes = requestBody.get("downCodes");
        ArrayList<String> recConditions = requestBody.get("recConditions");

        Long idLong = Long.parseLong(id);
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();

        for (int i = 0; i < conditions.size() && i < operations.size(); i++) {
            baseAnswer.add(new BaseCondition(conditions.get(i), operations.get(i)));
        }
        for (int i = 0; i < upCodes.size() && i < downCodes.size() && i < recConditions.size(); i++) {
            recursiveAnswer.add(new RecursiveCondition(downCodes.get(i), upCodes.get(i),recConditions.get(i)));
        }


        Problem problem = this.dataService.getProblem(idLong);
        if(problem != null) {
            boolean bool = problem.isSolution(baseAnswer, recursiveAnswer);
            return new ResponseEntity<>(bool, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //////////////////////////////////////////////////////////////////

    @PostMapping("sol/recursiveSum")
    public ResponseEntity<Integer> solRecursiveSum (String input){
        int [] array = parseIntegerArray(input);
        if(array != null){
            if (array.length == 1){
                int n = array[0];
                if(n >= 0){
                    int sum = (n * (n+1))/2;
                    return new ResponseEntity<>(sum, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    ////////////////////////////////////////////////////////////////

    private static int[] parseIntegerArray(String input) {
        String[] numString = input.split(",");

        // Crear un array para almacenar los enteros parseados
        int[] nums = new int[numString.length];

        // Parsear cada substring a un entero
        for (int i = 0; i < numString.length; i++) {
            try {
                nums[i] = Integer.parseInt(numString[i].trim()); // Eliminar espacios en blanco alrededor del número
            } catch (NumberFormatException e) {
                return null;
            }
        }

        return nums;
    }


}
