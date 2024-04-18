package com.example.r3.controller;


import com.example.r3.model.entities.BaseCondition;
import com.example.r3.model.entities.Problem;
import com.example.r3.model.entities.RecursiveCondition;
import com.example.r3.model.services.DataService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProblemLoader {

    @Autowired
    DataService dataService;

    @Autowired
    EntityManager entityManager;
    public void addRecursiveSum(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();
        RecursiveCondition recSol = new RecursiveCondition("n - 1", "+ n",1);
        BaseCondition baseSol = new BaseCondition("n == 1", "return 1",1);
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
        String function = "sumatorioRecursivo";
        String args = "n";
        String url = "/../img/Sumatorio.png";
        int points = 200;
        int difficulty = 1;



        Problem recursiveSumatory = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, baseAnswer, recursiveAnswer);
        this.dataService.addProblem(recursiveSumatory);
    }

    public void addSlowAdd(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();
        RecursiveCondition recSol = new RecursiveCondition("a, b - 1", "+ 1",1);
        BaseCondition baseSol = new BaseCondition("b == 0", "return a",1);
        RecursiveCondition recSol2 = new RecursiveCondition("a - 1, b", "+ 1",2);
        BaseCondition baseSol2 = new BaseCondition("a == 0", "return b",2);
        recursiveAnswer.add(recSol);
        baseAnswer.add(baseSol);
        recursiveAnswer.add(recSol2);
        baseAnswer.add(baseSol2);

        List<String> operations = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        List<String> upCodes = new ArrayList<>();
        List<String> downCodes = new ArrayList<>();

        operations.add("return a");
        operations.add("return b");
        operations.add("return a + 1");

        conditions.add("a == 0");
        conditions.add("b == 0");
        conditions.add("a < b");

        upCodes.add("+ 1");
        upCodes.add("+ 2");
        upCodes.add("+ a");

        downCodes.add("a - 1, b");
        downCodes.add("a, b - 1");
        downCodes.add("a - 1, b - 1");


        String title = "Suma Lenta";
        String statement = "Diseña una función sumaLenta(a, b) que calcule recursivamente la suma de los enteros positivos a y b, donde a y b son los sumandos dados.";
        String function = "sumaLenta";
        String args = "a, b";
        String url = "/../img/SumaLenta.png";
        int points = 400;
        int difficulty = 2;



        Problem recursiveSumatory = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, baseAnswer, recursiveAnswer);
        this.dataService.addProblem(recursiveSumatory);
    }

    public void addMult(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();
        RecursiveCondition recSol = new RecursiveCondition("a, b - 1", "+ a",1);
        BaseCondition baseSol = new BaseCondition("b == 0", "return 0",1);
        RecursiveCondition recSol2 = new RecursiveCondition("a - 1, b", "+ b",2);
        BaseCondition baseSol2 = new BaseCondition("a == 0", "return 0",2);
        recursiveAnswer.add(recSol);
        baseAnswer.add(baseSol);
        recursiveAnswer.add(recSol2);
        baseAnswer.add(baseSol2);

        List<String> operations = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        List<String> upCodes = new ArrayList<>();
        List<String> downCodes = new ArrayList<>();

        operations.add("return a");
        operations.add("return b");
        operations.add("return 0");
        operations.add("return 1");


        conditions.add("a == 0");
        conditions.add("b == 0");
        conditions.add("a < b");
        conditions.add("a > b");
        conditions.add("b < 0");
        conditions.add("a < 0");


        upCodes.add("+ b");
        upCodes.add("+ 1");
        upCodes.add("+ a");
        upCodes.add("- b");
        upCodes.add("- a");

        downCodes.add("a - 1, b");
        downCodes.add("a, b - 1");
        downCodes.add("a + 1, b");
        downCodes.add("a, b + 1");


        String title = "Multiplicación";
        String statement = "Diseña una función multiplication(a, b) que calcule recursivamente la multiplicación de los enteros positivos a y b, donde a y b son los factores dados.";
        String function = "multiplication";
        String args = "a, b";
        String url = "/../img/Multiplicación.png";
        int points = 400;
        int difficulty = 2;



        Problem recursiveSumatory = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, baseAnswer, recursiveAnswer);
        this.dataService.addProblem(recursiveSumatory);
    }
}
