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
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();
        recursiveAnswer.add(new RecursiveCondition(downCode, upCode));
        baseAnswer.add(new BaseCondition(condition, operation));
        Problem problem = this.dataService.getProblem(idLong);
        boolean bool = problem.isSolution(baseAnswer,recursiveAnswer);
        model.addAttribute("problem",problem);
        model.addAttribute("bool",bool);
        return "solution";
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
            List<BaseCondition> baseAnswer = new ArrayList<>();
            List<RecursiveCondition> recursiveAnswer = new ArrayList<>();
            RecursiveCondition recSol = new RecursiveCondition("n - 1", "+ n");
            BaseCondition baseSol = new BaseCondition("n == 1", "return 1");
            recursiveAnswer.add(recSol);
            baseAnswer.add(baseSol);

            List<String> operations = new ArrayList<>();
            List<String> conditions = new ArrayList<>();
            List<String> upCodes = new ArrayList<>();
            List<String> downCodes = new ArrayList<>();

            operations.add("return n / 2");
            operations.add("return 1");
            operations.add("return n * 2");

            conditions.add("n == 1");
            conditions.add("n > 1");
            conditions.add("n != 1");

            upCodes.add("+ 1");
            upCodes.add("- n");
            upCodes.add("+ n");

            downCodes.add("n + 1");
            downCodes.add("n / 2");
            downCodes.add("n - 1");


            String title = "Sumatorio recursivo";
            String statement = "Diseña una función sumatorioRecursivo(n) que calcule el valor del sumatorio de los primeros n números naturales. El parámetro n, entero positivo, representa hasta que número habrá que sumar.  ";
            String function = "sumatorioRecursivo(n)";
            int points = 200;
            int difficulty = 1;


            Problem recursiveSumatory = new Problem(title,statement,
                    function, points,difficulty,operations, conditions, upCodes, downCodes, baseAnswer, recursiveAnswer);
            this.dataService.addProblem(recursiveSumatory);
            init = true;
        }
    }
}
