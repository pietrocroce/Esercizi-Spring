package com.example.Esercizi.Spring.Esercizio3;

import com.example.Esercizi.Spring.Esercizio2.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller3Esercizio3 {
    //Exercise 3: Create a DeleteMapping to delete a meal by name
    //
    //1 - Create a new endpoint "/meal/{name}" using the @DeleteMapping annotation.
    // 2 - In the method, add a PathVariable for the name.
    // 3 - Delete the meal with the corresponding name.
    @DeleteMapping(value="/meal/{name}")
    public ResponseEntity<String> deleteName(
            @PathVariable("name") String name){
        List<Meal> mealList = new ArrayList<>();
        for(Meal x : mealList){
            if(x.getName().equals(name)){
                mealList.remove(x);
            }
        }
        return ResponseEntity.ok("Il nome è stato cancellato");
    }
}
