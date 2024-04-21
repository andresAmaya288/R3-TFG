package com.example.r3.controller;

import com.example.r3.model.entities.BaseCondition;
import com.example.r3.model.entities.Problem;
import com.example.r3.model.entities.RecursiveCondition;
import com.example.r3.model.entities.Solution;
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
            Solution solution = new Solution(baseAnswer,recursiveAnswer);
            boolean bool = problem.isSolution(solution);
            return new ResponseEntity<>(bool, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    //////////////////////////////////////////////////////////////////

    @PostMapping("/sol/sumatorioRecursivo")
    public ResponseEntity<Integer> solRecursiveSum (@RequestBody String input){
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

    @PostMapping("/sub/sumatorioRecursivo")
    public ResponseEntity<Integer> subRecursiveSum (@RequestBody Map<String,String> requestBody){

        String input = requestBody.get("input");
        String downCode = requestBody.get("downCode");

        int [] array = parseIntegerArray(input);
        int subpro = 0;
        boolean aux = true;
        if(array != null){
            if (array.length == 1){
                int n = array[0];
                if(n >= 0){
                    switch (downCode){
                        case "n + 1":
                            subpro = n + 1;
                            break;
                        case "n - 1":
                            subpro = n - 1;
                            break;
                        case "n / 2":
                            subpro = n / 2;
                            break;
                        default:
                            aux = false;
                            break;
                    }
                    if(aux){
                        return new ResponseEntity<>(subpro, HttpStatus.OK);
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    ////////////////////////////////////////////////////////////////

    @PostMapping("/sol/sumaLenta")
    public ResponseEntity<Integer> solSlowAdd (@RequestBody String input){
        int [] array = parseIntegerArray(input);
        if(array != null){
            if (array.length == 2){
                int a = array[0];
                int b = array[1];
                if(a >= 0 && b >= 0){
                    int sum = a + b;
                    return new ResponseEntity<>(sum, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/sub/sumaLenta")
    public ResponseEntity<String> subSlowAdd (@RequestBody Map<String,String> requestBody){

        String input = requestBody.get("input");
        String downCode = requestBody.get("downCode");

        int [] array = parseIntegerArray(input);
        String subpro = "";
        boolean aux = true;
        if(array != null){
            if (array.length == 2){

                int a = array[0];
                int b = array[1];
                if(a >= 0 && b >= 0){
                    switch (downCode){
                        case "a - 1, b":
                            subpro = (a-1) + ", " + b;
                            break;
                        case "a - 1, b - 1":
                            subpro = (a-1) + ", " + (b-1);
                            break;
                        case "a, b - 1":
                            subpro = a + ", " + (b-1);
                            break;
                        default:
                            aux = false;
                            break;
                    }
                    if(aux){
                        return new ResponseEntity<>(subpro, HttpStatus.OK);
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    ////////////////////////////////////////////////////////////////

    @PostMapping("/sol/multiplication")
    public ResponseEntity<Integer> solMultiplication (@RequestBody String input){
        int [] array = parseIntegerArray(input);
        if(array != null){
            if (array.length == 2){
                int a = array[0];
                int b = array[1];
                if(a >= 0 && b >= 0){
                    int sum = a * b;
                    return new ResponseEntity<>(sum, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/sub/multiplication")
    public ResponseEntity<String> subMultiplication (@RequestBody Map<String,String> requestBody){

        String input = requestBody.get("input");
        String downCode = requestBody.get("downCode");

        int [] array = parseIntegerArray(input);
        String subpro = "";
        boolean aux = true;
        if(array != null){
            if (array.length == 2){

                int a = array[0];
                int b = array[1];
                if(a >= 0 && b >= 0){
                    switch (downCode){
                        case "a - 1, b":
                            subpro = (a-1) + ", " + b;
                            break;
                        case "a + 1, b":
                            subpro = (a+1) + ", " + b;
                            break;
                        case "a, b + 1":
                            subpro = a + ", " + (b+1);
                            break;
                        case "a, b - 1":
                            subpro = a + ", " + (b-1);
                            break;
                        default:
                            aux = false;
                            break;
                    }
                    if(aux){
                        return new ResponseEntity<>(subpro, HttpStatus.OK);
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    ////////////////////////////////////////////////////////////////

    @PostMapping("/sol/potenciaRecursiva")
    public ResponseEntity<Integer> solRecPow (@RequestBody String input){
        int [] array = parseIntegerArray(input);
        if(array != null){
            if (array.length == 2){
                int b = array[0];
                int e = array[1];
                if(b >= 0 && e >= 0){
                    int pow = (int) Math.pow(b,e);
                    return new ResponseEntity<>(pow, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/sub/potenciaRecursiva")
    public ResponseEntity<String> subRecPow (@RequestBody Map<String,String> requestBody){

        String input = requestBody.get("input");
        String downCode = requestBody.get("downCode");

        int [] array = parseIntegerArray(input);
        String subpro = "";
        boolean aux = true;
        if(array != null){
            if (array.length == 2){

                int b = array[0];
                int e = array[1];
                if(b >= 0 && e >= 0){
                    switch (downCode){
                        case "b, e - 1":
                            subpro = b + ", " + (e - 1);
                            break;
                        case "b, e + 1":
                            subpro = b + ", " + (e + 1);
                            break;
                        case "b, e // 2":
                            subpro = b + ", " + (e / 2);
                            break;
                        case "b - 1, e":
                            subpro = (b - 1) + ", " + e;
                            break;
                        case "b + 1, e":
                            subpro = (b + 1) + ", " + e;
                            break;
                        case "b // 2, e":
                            subpro = (b / 2) + ", " + e;
                            break;
                        default:
                            aux = false;
                            break;
                    }
                    if(aux){
                        return new ResponseEntity<>(subpro, HttpStatus.OK);
                    }
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    ////////////////////////////////////////////////////////////////

    @PostMapping("/sol/fibonacci")
    public ResponseEntity<Integer> solFibonacci (@RequestBody String input){
        int [] array = parseIntegerArray(input);
        if(array != null){
            if (array.length == 1){
                int n = array[0];
                if(n >= 0){
                    int temp, aux = 1, aux2 = 0;
                    for (int i = 0; i < n; i++) {
                        temp = aux + aux2;
                        aux2 = aux;
                        aux = temp;
                    }
                    if (n == 0){
                        aux = 0;
                    }
                    return new ResponseEntity<>(aux, HttpStatus.OK);
                }
            }
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/sub/fibonacci")
    public ResponseEntity<String> subFibonacci (@RequestBody Map<String,String> requestBody){

        String input = requestBody.get("input");
        String downCode = requestBody.get("downCode");

        int [] array = parseIntegerArray(input);
        String subpro = "";
        boolean aux = true;
        if(array != null){
            if (array.length == 1){

                int n = array[0];
                if(n >= 0 ){
                    switch (downCode){
                        case "n - 1":
                            subpro = String.valueOf(n - 1);
                            break;
                        case "n - 2":
                            subpro = String.valueOf(n - 2);
                            break;
                        case "n":
                            subpro = String.valueOf(n);
                            break;
                        case "n / 2":
                            subpro = String.valueOf(n/2);
                            break;
                        case "n + 1":
                            subpro = String.valueOf(n + 1);
                            break;
                        default:
                            aux = false;
                            break;
                    }
                    if(aux){
                        return new ResponseEntity<>(subpro, HttpStatus.OK);
                    }
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
