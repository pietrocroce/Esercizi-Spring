package com.example.Esercizi.Spring.Esercizio3;

import com.example.Esercizi.Spring.Esercizio2.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller2Esercizio3 {
//Exercise 2: Create a PostMapping to update a meal by name
//
//1 - Create a new endpoint "/meal/{name}" using the @PutMapping annotation.
// 2 - In the method, add a PathVariable for the name and a RequestBody for the updated Meal object.
// 3 - Update the meal with the corresponding name using the information from the RequestBody.
    @PutMapping(value="/meal/{name}")
    public ResponseEntity<String> updateMeal(
            @PathVariable("name") String name,
            @RequestBody Meal updateMeal){
            List<Meal> mealList = new ArrayList<>();
        for(Meal x : mealList){
            if(x.getName().equals(name)){
                x.setName(updateMeal.getName());
            }
        }
        return ResponseEntity.ok("Rinnovato nome");
    }
}
