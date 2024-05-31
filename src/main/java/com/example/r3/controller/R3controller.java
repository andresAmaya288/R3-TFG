package com.example.r3.controller;

import com.example.r3.model.entities.User;
import com.example.r3.model.services.DataService;
import com.example.r3.model.services.ProblemLoader;
import jakarta.persistence.EntityManager;
import jakarta.servlet.http.HttpServletRequest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
        model.addAttribute("currentU",request.getUserPrincipal());

        return "index";
    }



    @GetMapping("/problem/{id}")
    public String problem (Model model, HttpServletRequest request, @PathVariable String id){
        this.load();
        Long idLong = Long.parseLong(id);
        model.addAttribute("problem",this.dataService.getProblem(idLong));
        model.addAttribute("problems",this.dataService.getProblemValues());
        model.addAttribute("currentU",request.getUserPrincipal());

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

    @GetMapping("/login")
    public String login(Model model,HttpServletRequest request) {
        this.load();
        model.addAttribute("problems",this.dataService.getProblemValues());
        model.addAttribute("currentU",request.getUserPrincipal());

        return "login";
    }

    @GetMapping("/register")
    public String register(Model model,HttpServletRequest request) {
        this.load();
        model.addAttribute("problems",this.dataService.getProblemValues());
        model.addAttribute("currentU",request.getUserPrincipal());
        return "register";
    }


    @PostMapping ("/register")
    public String singUpConfirmation(Model model, @RequestBody @RequestParam String username, @RequestBody @RequestParam String password, HttpServletRequest request){
        this.load();
        model.addAttribute("problems",this.dataService.getProblemValues());
        model.addAttribute("currentU",request.getUserPrincipal());

        User newUser = new User(username,password, "user");
        newUser = this.dataService.addUser(newUser);
        if (request.getUserPrincipal() != null){
            model.addAttribute("name", request.getUserPrincipal().getName());
        }
        return "login";
    }


    @GetMapping("/ranking")
    public String userList(Model model,HttpServletRequest request) {
        this.load();
        model.addAttribute("problems",this.dataService.getProblemValues());
        model.addAttribute("currentU",request.getUserPrincipal());
        List<User> users = this.dataService.getUsersSortedByScore();
        model.addAttribute("users",users);
        return "ranking";
    }

    @GetMapping("/zone")
    public String zone(Model model,HttpServletRequest request) {
        this.load();
        model.addAttribute("problems",this.dataService.getProblemValues());
        model.addAttribute("currentU",request.getUserPrincipal());
        if(request.getUserPrincipal() != null) {
            model.addAttribute("user", this.dataService.getUser(request.getUserPrincipal().getName()));
        }
        return "userZone";
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
            dataService.addUser(new User("a","a"));
            init = true;
        }
    }
}
