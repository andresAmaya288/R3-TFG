package com.example.r3.controller;

import com.example.r3.model.services.DataService;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@NoArgsConstructor
@Controller
public class R3controller {

    @Autowired
    DataService dataService;

    @Autowired
    EntityManager entityManager;

    @Autowired
    ProblemLoader problemLoader;


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
        model.addAttribute("problems",this.dataService.getProblemValues());

        switch (this.dataService.getProblem(idLong).getTitle()){

            case "Intercalar":
                return "problemInterleave";
            case "Pares e Impares":
                return "problemEvenOdds";
            case "Permutación de Inversión":
            case "Ordenar":
                return "problem2Subs";
            default:
                return "problem";

        }
    }




    //////////////////////////////////////////////////////////////////////////////
    private void load (){
        if(!init) {
            problemLoader.addRecursiveSum();
            problemLoader.addSlowAdd();
            problemLoader.addMult();
            problemLoader.addPow();
            problemLoader.addDigit();
            problemLoader.addFibonacci();
            problemLoader.addLength();
            problemLoader.addPrime();
            problemLoader.addInterLeave();
            problemLoader.addEvenOdds();
            problemLoader.addRevPerm();
            problemLoader.addMergeSort();
            init = true;
        }
    }
}
