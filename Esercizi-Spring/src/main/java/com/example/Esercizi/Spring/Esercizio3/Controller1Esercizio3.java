package com.example.Esercizi.Spring.Esercizio3;

import com.example.Esercizi.Spring.Esercizio2.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller1Esercizio3 {
    //Exercise 1: Create a PutMapping to add a new meal
    //
    //1 - Create a new endpoint "/meal" using the @PostMapping annotation.
    // 3 - In the method, add a RequestBody for the new Meal object.
    // 4 - Add the new meal to the list of meals.
    private List<Meal> mealList = new ArrayList<>();
    @GetMapping(value="/getlist")
    public ResponseEntity<List<Meal>> getMealList() {
        return ResponseEntity.ok(mealList);
    }

    @PostMapping(value="/post/meal")
    public ResponseEntity<String> getMeal(
            @RequestBody Meal meal){
        this.mealList.add(meal);
        return ResponseEntity.ok("Aggiunto pasto");
        }
    }

