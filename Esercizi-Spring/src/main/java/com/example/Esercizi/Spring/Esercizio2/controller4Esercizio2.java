package com.example.Esercizi.Spring.Esercizio2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
public class controller4Esercizio2 {
    //Exercise 4: Create a GetMapping that returns a meal by price range
    //
    //1 - Annotate a new class with the @RestController annotation.
    // 2 - Create a new endpoint "/meal/price" using the @GetMapping annotation.
    // 3 - In the method, add two query parameters "min" and "max" using the @RequestParam annotation.
    // 4 - Return a list of Meal objects with prices within the specified range.
            List<Meal> mealList = Arrays.asList(
            new Meal("impepata_di_cozze","sugo_di_cozze",6.00),
            new Meal("tagliatelle al ragu","pasta lunga con ragu di cinghiale",12.00),
            new Meal("orata all'acqua pazza","orata cotta al forno con limone e pomodorini",13.00),
            new Meal("proscitto e melone","melone cantalupo con con prosciutto di parma",6.00),
            new Meal("parmigiana di melanzane","melanzane con formaggio,pomodoro",8.00),
            new Meal("coniglio all'ischitana","coniglio cotto con erbe selvatiche e pomodorini",20.00),
            new Meal("sorbetto al limone","dolce al limone",5.00));
    @GetMapping(value = "/meal/price")
    public ResponseEntity<?> getmealList(
            @RequestParam("min") double min,
            @RequestParam("max") double max) {
            List<Meal> listafiltrata= new ArrayList<>();
                for (Meal x : mealList) {
                    if (x.getPrice() >= min & x.getPrice() <= max) {
                         listafiltrata.add(x);
            }
        }return ResponseEntity.ok(listafiltrata);
    }
   }
