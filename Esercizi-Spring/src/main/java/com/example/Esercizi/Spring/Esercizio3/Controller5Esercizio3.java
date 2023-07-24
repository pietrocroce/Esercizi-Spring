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
public class Controller5Esercizio3 {
    //Exercise 5: Create a PutMapping to update the price of a meal by name
    //
    //1 - Create a new endpoint "/meal/{name}/price" using the @PutMapping annotation.
    // 2 - In the method, add a PathVariable for the name and a RequestBody for the updated price.
    // 3 - Update the price of the meal with the corresponding name using the information from the RequestBody.
    @PutMapping(value="/meal/{name}/price")
    public ResponseEntity<String> updatePriceByName(
            @PathVariable("name") String name,
            @RequestBody double price){
        List<Meal> mealList = new ArrayList<>();
        for(Meal x : mealList){
            if(x.getName().equals(name)){
                x.setPrice(price);
            }
        }
        return ResponseEntity.ok("Modificato il prezzo");
    }
}
