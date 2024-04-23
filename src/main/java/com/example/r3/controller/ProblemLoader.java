package com.example.r3.controller;


import com.example.r3.model.entities.BaseCondition;
import com.example.r3.model.entities.Problem;
import com.example.r3.model.entities.RecursiveCondition;
import com.example.r3.model.entities.Solution;
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

        RecursiveCondition recSol = new RecursiveCondition("n - 1", "+ n");
        BaseCondition baseSol = new BaseCondition("n == 1", "return 1");

        recursiveAnswer.add(recSol);
        baseAnswer.add(baseSol);

        Solution sol = new Solution(baseAnswer,recursiveAnswer);
        List<Solution> sols = new ArrayList<>();
        sols.add(sol);

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
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(recursiveSumatory);
    }

    public void addSlowAdd(){

        List<BaseCondition> baseAnswer1 = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer1 = new ArrayList<>();
        List<BaseCondition> baseAnswer2 = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer2 = new ArrayList<>();

        RecursiveCondition recSol = new RecursiveCondition("a, b - 1", "+ 1");
        BaseCondition baseSol = new BaseCondition("b == 0", "return a");
        RecursiveCondition recSol2 = new RecursiveCondition("a - 1, b", "+ 1");
        BaseCondition baseSol2 = new BaseCondition("a == 0", "return b");

        recursiveAnswer1.add(recSol);
        baseAnswer1.add(baseSol);
        recursiveAnswer2.add(recSol2);
        baseAnswer2.add(baseSol2);

        Solution solution1 = new Solution(baseAnswer1,recursiveAnswer1);
        Solution solution2 = new Solution(baseAnswer2,recursiveAnswer2);

        List<Solution> sols = new ArrayList<>();

        sols.add(solution1);
        sols.add(solution2);

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
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(recursiveSumatory);
    }

    public void addMult(){
        List<BaseCondition> baseAnswer1 = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer1 = new ArrayList<>();
        List<BaseCondition> baseAnswer2 = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer2 = new ArrayList<>();

        RecursiveCondition recSol = new RecursiveCondition("a, b - 1", "+ a");
        BaseCondition baseSol = new BaseCondition("b == 0", "return 0");
        RecursiveCondition recSol2 = new RecursiveCondition("a - 1, b", "+ b");
        BaseCondition baseSol2 = new BaseCondition("a == 0", "return 0");

        recursiveAnswer1.add(recSol);
        baseAnswer1.add(baseSol);
        recursiveAnswer2.add(recSol2);
        baseAnswer2.add(baseSol2);

        Solution solution1 = new Solution(baseAnswer1,recursiveAnswer1);
        Solution solution2 = new Solution(baseAnswer2,recursiveAnswer2);

        List<Solution> sols = new ArrayList<>();

        sols.add(solution1);
        sols.add(solution2);

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
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(recursiveSumatory);
    }

    public void addPow(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();

        RecursiveCondition recSol = new RecursiveCondition("b, e - 1", "* e");
        BaseCondition baseSol = new BaseCondition("e == 0", "return 1");

        recursiveAnswer.add(recSol);
        baseAnswer.add(baseSol);

        Solution sol = new Solution(baseAnswer,recursiveAnswer);
        List<Solution> sols = new ArrayList<>();
        sols.add(sol);

        List<String> operations = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        List<String> upCodes = new ArrayList<>();
        List<String> downCodes = new ArrayList<>();

        operations.add("return 0");
        operations.add("return 1");
        operations.add("return -1");

        conditions.add("e == 0");
        conditions.add("b == 0");
        conditions.add("b > 0");
        conditions.add("e > 0");

        upCodes.add("/ b");
        upCodes.add("* b");
        upCodes.add("+ b");
        upCodes.add("/ e");
        upCodes.add("* e");
        upCodes.add("+ e");

        downCodes.add("b, e - 1");
        downCodes.add("b, e + 1");
        downCodes.add("b, e // 2");
        downCodes.add("b - 1, e");
        downCodes.add("b + 1, e");
        downCodes.add("b // 2, e");


        String title = "Potencias recursivas";
        String statement = "Diseña una función potenciaRecursiva(b, e) para calcular potencias de forma recursiva, dónde el parámetro b, entero, es la base y e, entero, es el exponente.";
        String function = "potenciaRecursiva";
        String args = "b, e";
        String url = "/../img/Potencia.png";
        int points = 400;
        int difficulty = 2;



        Problem recursiveSumatory = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(recursiveSumatory);
    }

    public void addFibonacci(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();
        List<BaseCondition> baseAnswer2 = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer2 = new ArrayList<>();

        RecursiveCondition recSol = new RecursiveCondition("n - 1", "+ fibonacci(n - 2)");
        RecursiveCondition recSol2 = new RecursiveCondition("n - 2", "+ fibonacci(n - 1)");
        BaseCondition baseSol = new BaseCondition("n == 1", "return 1");
        BaseCondition baseSol12 = new BaseCondition("n <= 0", "return 0");
        BaseCondition baseSol2 = new BaseCondition("n == 1", "return 1");
        BaseCondition baseSol22 = new BaseCondition("n <= 0", "return 0");

        recursiveAnswer.add(recSol);
        baseAnswer.add(baseSol);
        baseAnswer.add(baseSol12);

        recursiveAnswer2.add(recSol2);
        baseAnswer2.add(baseSol2);
        baseAnswer2.add(baseSol22);

        Solution sol = new Solution(baseAnswer,recursiveAnswer);
        Solution sol2 = new Solution(baseAnswer2,recursiveAnswer2);

        List<Solution> sols = new ArrayList<>();
        sols.add(sol);
        sols.add(sol2);

        List<String> operations = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        List<String> upCodes = new ArrayList<>();
        List<String> downCodes = new ArrayList<>();

        operations.add("return 0");
        operations.add("return 1");
        operations.add("return -1");

        conditions.add("n <= 0");
        conditions.add("n == 1");
        conditions.add("n != 1");
        conditions.add("n <= 1");

        upCodes.add("+ n");
        upCodes.add("+ 1");
        upCodes.add("+ fibonacci(n - 1)");
        upCodes.add("+ fibonacci(n - 2)");
        upCodes.add("+ fibonacci(n)");


        downCodes.add("n - 1");
        downCodes.add("n + 1");
        downCodes.add("n - 2");
        downCodes.add("n");
        downCodes.add("n / 2");



        String title = "Fibonacci";
        String statement = "Diseña una función fibonacci(n) que calcúle el enésimo término de la sucesión de fibonacci. Dicha sucesión parte de los términos 1 y 0 y a partir de ahí cada término se calcula cómo la suma de los dos anteriores. El índice n es un número entero positivo.";
        String function = "fibonacci";
        String args = "n";
        String url = "/../img/Fibonacci.png";
        int points = 600;
        int difficulty = 3;



        Problem fibonacci = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(fibonacci);
    }

    public void addDigit(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();
        List<BaseCondition> baseAnswer2 = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer2 = new ArrayList<>();

        RecursiveCondition recSol = new RecursiveCondition("n - 1", "+ fibonacci(n - 2)");
        BaseCondition baseSol = new BaseCondition("n == 1", "return 1");
        BaseCondition baseSol12 = new BaseCondition("n <= 0", "return 0");


        recursiveAnswer.add(recSol);
        baseAnswer.add(baseSol);
        baseAnswer.add(baseSol12);

        Solution sol = new Solution(baseAnswer,recursiveAnswer);

        List<Solution> sols = new ArrayList<>();
        sols.add(sol);
;

        List<String> operations = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        List<String> upCodes = new ArrayList<>();
        List<String> downCodes = new ArrayList<>();

        operations.add("return True");
        operations.add("return False");

        conditions.add("n // 10 == d");
        conditions.add("n % 10 == d");
        conditions.add("n < 10");
        conditions.add("n / 10 == d");
        conditions.add("n > 10");


        upCodes.add(" ");
        upCodes.add("and (n % 10 == d)");
        upCodes.add("and (n // 10 == d)");
        upCodes.add("and (n / 10 == d)");

        downCodes.add("n // 10, d");
        downCodes.add("n % 10, d");
        downCodes.add("n, d // 10");
        downCodes.add("n, d % 10");



        String title = "Contiene el Digito ?";
        String statement = "Diseña una función contieneDigito(n, d) que devuelva True si el número n contiene el digito d. Dónde N es un entero positivo y d es un digito entre el 0 y el 9.";
        String function = "contieneDigito";
        String args = "n, d";
        String url = "/../img/Digito.png";
        int points = 200;
        int difficulty = 1;



        Problem fibonacci = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(fibonacci);
    }

}
