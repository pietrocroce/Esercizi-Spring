package com.example.Esercizi.Spring.Esercizio1.parte2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Controller2 {

    //Exercise 2: Create a GetMapping that returns a ResponseEntity as a response
    //
    //1 - Create a new endpoint "/greeting" using the @GetMapping annotation.
    // 2 - In the method, return a ResponseEntity object with a string message such as "Good Afternoon!".
    // 3 - You can also set the HTTP status code in the ResponseEntity, such as "200 OK".
    @GetMapping(value = "/greeting")
    public ResponseEntity<String> index(){
        if(new Date().getHours() < 13){
            ResponseEntity.status(404).body("It's not afternoon");
            return ResponseEntity.badRequest().body("It's not afternoon");
        }
        return ResponseEntity.ok("Good Afternoon");
    }
}
