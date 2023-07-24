package com.example.Esercizi.Spring.Esercizio2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class Controller1Exercise2 {
    //Exercise 1: Create a GetMapping that returns a list of meals
    //
    //1 - Annotate a new class with the @RestController annotation.
    // 2 - Create a new endpoint "/meals" using the @GetMapping annotation.
    // 3 - In the method, return a list of Meal objects.
 private List<Meal> mealList = Arrays.asList(
                new Meal("impepata di cozze","sugo di cozze",6.00),
                new Meal("tagliatelle al ragu","pasta lunga con ragu di cinghiale",12.00),
                new Meal("orata all'acqua pazza","orata cotta al forno con limone e pomodorini",13.00),
                new Meal("proscitto e melone","melone cantalupo con con prosciutto di parma",6.00),
                new Meal("parmigiana di melanzane","melanzane con formaggio,pomodoro",8.00),
                new Meal("coniglio all'ischitana","coniglio cotto con erbe selvatiche e pomodorini",20.00),
                new Meal("sorbetto al limone","dolce al limone",5.00));
    @GetMapping(value="/meals")
    public ResponseEntity<List<Meal>> index(){
        return ResponseEntity.ok(
               mealList);
    }
}

