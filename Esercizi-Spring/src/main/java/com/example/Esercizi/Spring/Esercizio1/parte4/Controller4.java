package com.example.Esercizi.Spring.Esercizio1.parte4;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class Controller4 {
    //Exercise 4: Create a GetMapping that returns 400 - Bad request or 200 - OK based on a random boolean
    //
    //1 - Annotate a new class with the @RestController annotation.
    // 2 - Create a new endpoint "/random" using the @GetMapping annotation.
    // 3 - In the method, return a ResponseEntity with 200 OK or 400 Bad Request based on the result of new Random().nextBoolean()
    @GetMapping(value="/random")
    public ResponseEntity<String>rispostaACaso(){
        if(new Random().nextBoolean()== false){
            ResponseEntity.status(404).body("Il boolean è false");
            return ResponseEntity.badRequest().body("Il boolean è false");
        }return ResponseEntity.ok("Boolean is true");
    }
}
