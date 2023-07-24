package com.example.Esercizi.Spring.Esercizio1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    //Exercise 1: Create a GetMapping that returns a basic "string" as a response
    //
    //1 - Create a new endpoint "/hello" using the @GetMapping annotation.
    // 2 - In the method, return a simple string such as "Hello World!".
    @GetMapping(value = "/hello")
    public String ciao(){
        return "Hello World!";
    }
}
