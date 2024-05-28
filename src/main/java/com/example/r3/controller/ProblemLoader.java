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


        RecursiveCondition recSol = new RecursiveCondition("n // 10, d", " ");
        BaseCondition baseSol = new BaseCondition("n % 10 == d", "return True");
        BaseCondition baseSol12 = new BaseCondition("n < 10", "return False");


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

        conditions.add("n % 10 == d");
        conditions.add("n % 10 != d");
        conditions.add("n < 10");
        conditions.add("n > 10");


        upCodes.add(" ");
        upCodes.add("and (n % 10 == d)");
        upCodes.add("and (n // 10 == d)");
        upCodes.add("and (n / 10 == d)");

        downCodes.add("n // 10, d");
        downCodes.add("n % 10, d");
        downCodes.add("n, d // 10");
        downCodes.add("n, d % 10");



        String title = "Contiene Digito";
        String statement = "Diseña una función contieneDigito(n, d) que devuelva True si el número n contiene el digito d. Dónde N es un entero positivo y d es un digito entre el 0 y el 9.";
        String function = "contieneDigito";
        String args = "n, d";
        String url = "/../img/Digito.png";
        int points = 200;
        int difficulty = 1;



        Problem digit = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(digit);
    }

    public void addLength(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();

        RecursiveCondition recSol = new RecursiveCondition("l[1:]", "+ 1");
        BaseCondition baseSol = new BaseCondition("not l", "return 0");

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

        conditions.add("not l");
        conditions.add("l[0] == null");
        conditions.add("l[0] == 0");

        upCodes.add("+ 1");
        upCodes.add("- 1");
        upCodes.add("+ 2");


        downCodes.add("l[:1]");
        downCodes.add("l[0:]");
        downCodes.add("l[:2]");
        downCodes.add("l[1:]");



        String title = "Longitud Lista";
        String statement = "Diseña una función longitudLista(l) para calcular la longitud de una lista de forma recursiva, dónde el parámetro l es una lista de enteros de la cual desconocemos la longitud. Además no será posible utilizar el método len(l)";
        String function = "longitudLista";
        String args = "l";
        String url = "/../img/Longitud.png";
        int points = 200;
        int difficulty = 1;



        Problem recursiveSumatory = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(recursiveSumatory);
    }

    public void addPrime(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();

        RecursiveCondition recSol = new RecursiveCondition("n, d + 1", " ");
        BaseCondition baseSol = new BaseCondition("d * d > n", "return True");
        BaseCondition baseSol2= new BaseCondition("n % d == 0", "return False");

        recursiveAnswer.add(recSol);
        baseAnswer.add(baseSol);
        baseAnswer.add(baseSol2);

        Solution sol = new Solution(baseAnswer,recursiveAnswer);
        List<Solution> sols = new ArrayList<>();
        sols.add(sol);

        List<String> operations = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        List<String> upCodes = new ArrayList<>();
        List<String> downCodes = new ArrayList<>();

        operations.add("return True");
        operations.add("return False");

        conditions.add("2 * d > n");
        conditions.add("n / d == 0");
        conditions.add("n % d == 0");
        conditions.add("d * d > n");



        upCodes.add(" ");
        upCodes.add("and n / d == 0");
        upCodes.add("and not n / d == 0");


        downCodes.add("n, d + 1");
        downCodes.add("n, d + 2");
        downCodes.add("n + 2, d");
        downCodes.add("n + 1, d");



        String title = "Número Primo";
        String statement = "Crea una función llamada esPrimo(n, d) que verifica si un número n es primo, empezando a comprobar su divisibilidad desde d.Los parámetros de entrada siempre serán enteros positivos, y se garantiza que d será menor que n y mayor que 1";
        String function = "esPrimo";
        String args = "n, d";
        String url = "/../img/Primo.png";
        int points = 600;
        int difficulty = 3;



        Problem recursiveSumatory = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(recursiveSumatory);
    }

    public void addInterLeave(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();

        RecursiveCondition recSol = new RecursiveCondition("+ intercalar(a[1:], b[1:])", "[a[0]] + [b[0]]");
        BaseCondition baseSol = new BaseCondition("len(a) == 1", "return [a[0], b[0]]");

        recursiveAnswer.add(recSol);
        baseAnswer.add(baseSol);

        Solution sol = new Solution(baseAnswer,recursiveAnswer);
        List<Solution> sols = new ArrayList<>();
        sols.add(sol);

        List<String> operations = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        List<String> upCodes = new ArrayList<>();
        List<String> downCodes = new ArrayList<>();

        operations.add("return [a[1], b[1]]");
        operations.add("return [a[0], b[1]]");
        operations.add("return [a[0], b[0]]");
        operations.add("return [a[1], b[0]]");

        conditions.add("len(a) == 1");
        conditions.add("len(a) == 0");
        conditions.add("len(a) != 1");
        conditions.add("len(a) != 0");


        downCodes.add("+ intercalar(a[0:], b[1:])");
        downCodes.add("+ intercalar(a[1:], b[1:])");
        downCodes.add("+ intercalar(a[1:], b[0:])");
        downCodes.add("+ intercalar(a[0:], b[0:])");

        upCodes.add("[a[1]] + [b[1]]");
        upCodes.add("[a[0]] + [b[0]]");
        upCodes.add("[a[0]] + [b[1]]");
        upCodes.add("[a[1]] + [b[0]]");



        String title = "Intercalar";
        String statement = "Crea una función llamada intercalar(a, b) que intercala las listas a y b, intercalando los valores, enteros positivos de una lista y otra";
        String function = "intercalar";
        String args = "a, b";
        String url = "/../img/Intercalar.png";
        int points = 800;
        int difficulty = 4;



        Problem recursiveSumatory = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(recursiveSumatory);
    }

    public void addEvenOdds(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();

        RecursiveCondition recSol = new RecursiveCondition("a[2:]", "([a[0]] + a1, [a[1]] + a2)");
        BaseCondition baseSol = new BaseCondition("len(a) == 1", "return (a[0], [])");
        BaseCondition baseSol2= new BaseCondition("len(a) == 0", "return ([], [])");

        recursiveAnswer.add(recSol);
        baseAnswer.add(baseSol);
        baseAnswer.add(baseSol2);

        Solution sol = new Solution(baseAnswer,recursiveAnswer);
        List<Solution> sols = new ArrayList<>();
        sols.add(sol);

        List<String> operations = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        List<String> upCodes = new ArrayList<>();
        List<String> downCodes = new ArrayList<>();

        operations.add("return (a[0], [])");
        operations.add("return ([], a[0])");
        operations.add("return ([], [])");
        operations.add("return (a[1], [])");

        conditions.add("len(a) == 1");
        conditions.add("len(a) == 0");
        conditions.add("len(a) != 1");
        conditions.add("len(a) != 0");


        downCodes.add("a[1:]");
        downCodes.add("a[2:]");
        downCodes.add("a[0:]");


        upCodes.add("([a[0]] + a1, [a[1]] + a2)");
        upCodes.add("(a[0] + a1, a[1] + a2)");
        upCodes.add("([a[1]] + a1, [a[0]] + a1)");
        upCodes.add("(a[0] + a1, a[1] + a1)");




        String title = "Pares e Impares";
        String statement = "Crea una función llamada paresImpares(a) que divide la lista de enteros positivos a en 2 listas a1 y a2 conteniendo la primera los elementos con índice par y a2 los restantes";
        String args = "a";
        String function = "paresImpares";
        String url = "/../img/ParesImpares.png";
        int points = 800;
        int difficulty = 4;



        Problem newProblem = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols);
        this.dataService.addProblem(newProblem);
    }

    public void addRevPerm(){
        List<BaseCondition> baseAnswer = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer = new ArrayList<>();
        List<BaseCondition> baseAnswer2 = new ArrayList<>();
        List<RecursiveCondition> recursiveAnswer2 = new ArrayList<>();

        RecursiveCondition recSol = new RecursiveCondition("paresImpares(a)", "inBitPerm(a1) + inBitPerm(a2)");
        RecursiveCondition recSol2 = new RecursiveCondition("inBitPerm(a[:len(a) // 2]), inBitPerm(a[len(a) // 2:])", "interleave(a1, a2)");
        BaseCondition baseSol = new BaseCondition("len(a) <= 2", "return a");
        BaseCondition baseSol2 = new BaseCondition("len(a) <= 2", "return a");


        recursiveAnswer.add(recSol);
        baseAnswer.add(baseSol);

        recursiveAnswer2.add(recSol2);
        baseAnswer2.add(baseSol2);


        Solution sol = new Solution(baseAnswer,recursiveAnswer);
        Solution sol2 = new Solution(baseAnswer2,recursiveAnswer2);

        List<Solution> sols = new ArrayList<>();
        sols.add(sol);
        sols.add(sol2);


        List<String> operations = new ArrayList<>();
        List<String> conditions = new ArrayList<>();
        List<String> upCodes = new ArrayList<>();
        List<String> downCodes = new ArrayList<>();

        operations.add("return a");
        operations.add("return a[1:]");
        operations.add("not a[:1]");
        operations.add("return len(a)");

        conditions.add("len(a) < 1");
        conditions.add("len(a) <= 1");
        conditions.add("len(a) <= 2");
        conditions.add("len(a) < 2");


        downCodes.add("paresImpares(a)");
        downCodes.add("inBitPerm(a[:len(a) // 2]), inBitPerm(a[len(a) // 2:])");

        upCodes.add("interleave(a1, a2)");
        upCodes.add("inBitPerm(a1) + inBitPerm(a2)");


        String title = "Permutación de Inversión de Bits";
        String statement = "Desarrolla la función inBitPerm(a) que realice la permutación de inversión de bits en la lista de enteros a, utilizando las funciones paresImpares(a) para dividir la lista en índices pares e impares, e intercalar(a, b) para intercalar dos listas.";
        String args = "a";
        String function = "inBitPerm";
        String url = "/../img/InvertirPermutar.png";
        String extraFunction1 = "def intercalar(a, b):\n" +
                "    if len(a) == 1:\n" +
                "        return [a[0], b[0]]\n" +
                "    else:\n" +
                "        return [a[0]] + [b[0]] + intercalar(a[1:], b[1:])";
        String extrafuncion2 = "def paresImpares(a):\n" +
                "    if len(a) == 1:\n" +
                "        return (a[0], [])\n" +
                "    elif len(a) == 0:\n" +
                "        return ([], [])\n" +
                "    else:\n" +
                "        (a1,a2) = paresImpares(a[2:])\n" +
                "        return ([a[0]] + a1, [a[1]] + a2)";;
        int points = 600;
        int difficulty = 3;



        Problem newProblem = new Problem(title,statement,
                function,args,url, points,difficulty,operations, conditions, upCodes, downCodes, sols,extraFunction1,extrafuncion2);
        this.dataService.addProblem(newProblem);
    }

}
