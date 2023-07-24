package com.example.Esercizi.Spring.Esercizio3;

import com.example.Esercizi.Spring.Esercizio2.Meal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Controller4Esercizio3 {
    //Exercise 4: Create a DeleteMapping to delete all meals above a certain price
    //
    //1 - Create a new endpoint "/meal/price/{price}" using the @DeleteMapping annotation.
    // 2 - In the method, add a PathVariable for the price.
    // 3 - Delete all meals with a price above the price from the PathVariable.
    @DeleteMapping(value="/meal/price/{price}")
    public ResponseEntity<String> deleteByPrice(
            @PathVariable("price") double price){
        List<Meal> mealList = new ArrayList<>();
        for(Meal x : mealList){
            if(x.getPrice()==(price)){
                mealList.remove(x);
            }
        }
        return ResponseEntity.ok("Pasti cancellati dalla lista in base al prezzo");
    }
}
