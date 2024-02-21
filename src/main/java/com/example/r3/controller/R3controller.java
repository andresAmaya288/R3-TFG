package com.example.r3.controller;

import com.example.r3.model.entities.BaseCondition;
import com.example.r3.model.entities.Condition;
import com.example.r3.model.entities.Problem;
import com.example.r3.model.entities.RecursiveCondition;
import com.example.r3.model.services.DataService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;


@NoArgsConstructor
@Controller
public class R3controller {

    @Autowired
    DataService dataService;

    @Autowired
    EntityManager entityManager;

    static boolean init = false;

    @GetMapping("/")
    public String index (Model model, HttpServletRequest request){
        this.load();
        model.addAttribute("problems",this.dataService.getProblemValues());
        return "index";
    }
    @GetMapping("/problem/{id}")
    public String problem (Model model, HttpServletRequest request, @PathVariable String id){
        Long idLong = Long.parseLong(id);
        model.addAttribute("problem",this.dataService.getProblem(idLong));
        return "problem";
    }

    @GetMapping("/problem/{id}/solution")
    public String solution (Model model, HttpServletRequest request, @PathVariable String id, @RequestParam String condition, @RequestParam String operation, @RequestParam String upCode, @RequestParam String downCode){
        Long idLong = Long.parseLong(id);
        List<Condition> sol = new ArrayList<>() ;  //this.parseConditionList(conditions);
        sol.add(new BaseCondition(condition,operation));
        sol.add(new RecursiveCondition(downCode,upCode));
        Problem problem = this.dataService.getProblem(idLong);
        boolean bool = problem.isSolution(sol);
        model.addAttribute("problem",problem);
        model.addAttribute("bool",bool);
        return "problem";
    }


    //////////////////////////////////////////////////////////////////////////////
    private List<Condition> parseConditionList(String in){
        List <Condition> conditions = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(in);
        String token = stringTokenizer.nextToken("[=&]");
        while (stringTokenizer.hasMoreTokens()){
            /*
            token = stringTokenizer.nextToken("[=&]");

            if (token != "username")
                token = stringTokenizer.nextToken("[=&]");

             */
        }

        return conditions;
    }
    private void load (){
        if(!init) {
            List<Condition> answer = new ArrayList<>();
            answer.add(new RecursiveCondition("n - 1", " + n"));
            answer.add(new BaseCondition("n == 1", " return 1"));
            Problem recursiveSumatory = new Problem("Sumatorio recursivo", "Diseña una función sumatorioRecursivo(n) que calcule el valor del sumatorio de los primeros n números naturales. El parámetro n, entero positivo, representa hasta que número habrá que sumar.  ",
                    "hello", 1, 200, answer);
            this.dataService.addProblem(recursiveSumatory);
            init = true;
        }
    }
}
