package com.example.Esercizi.Spring.Esercizio1.parte3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller3 {
    //Exercise 3: Create a new class with a GetMapping that returns a ResponseEntity a
    //
    //1 - Annotate a new class with the @RestController annotation.
    // 2 - Create a new endpoint "/info" using the @GetMapping annotation.
    // 3 - In the method, return a ResponseEntity with 200 OK
@GetMapping(value="/info")
    public ResponseEntity<String> information(){
    return ResponseEntity.ok("My name is Pietro and i am a Java'student");
}
}
