package com.example.Esercizi.Spring.Controller;

import com.example.Esercizi.Spring.Dao.MealDao;
import com.example.Esercizi.Spring.Meal;
import com.example.Esercizi.Spring.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {
    private Service mealService;
    @Autowired
    private MealDao mealDao;
    @Autowired
    public Controller(Service mealService) {
        this.mealService = mealService;
    }

    //Exercise 1: Create a GetMapping that returns a basic "string" as a response
    //
    //1 - Create a new endpoint "/hello" using the @GetMapping annotation.
    // 2 - In the method, return a simple string such as "Hello World!".
    @GetMapping(value = "/hello")
    public String ciao(){
        return "Hello World!";
    }

    //Exercise 2: Create a GetMapping that returns a ResponseEntity as a response
    //
    //1 - Create a new endpoint "/greeting" using the @GetMapping annotation.
    // 2 - In the method, return a ResponseEntity object with a string message such as "Good Afternoon!".
    // 3 - You can also set the HTTP status code in the ResponseEntity, such as "200 OK".
    @GetMapping(value = "/greeting")
    public ResponseEntity<String> goodAfternoon(){
        if(new Date().getHours() < 13){
            ResponseEntity.status(404).body("It's not afternoon");
            return ResponseEntity.badRequest().body("It's not afternoon");
        }
        return ResponseEntity.ok("Good Afternoon");
    }
    //Exercise 3: Create a new class with a GetMapping that returns a ResponseEntity a
    //
    //1 - Annotate a new class with the @RestController annotation.
    // 2 - Create a new endpoint "/info" using the @GetMapping annotation.
    // 3 - In the method, return a ResponseEntity with 200 OK
    @GetMapping(value="/info")
    public ResponseEntity<String> information(){
        return ResponseEntity.ok("My name is Pietro and i am a Java'student");
    }
    //Exercise 4: Create a GetMapping that returns 400 - Bad request or 200 - OK based on a random boolean
    //
    //1 - Annotate a new class with the @RestController annotation.
    // 2 - Create a new endpoint "/random" using the @GetMapping annotation.
    // 3 - In the method, return a ResponseEntity with 200 OK or 400 Bad Request based on the result of new Random().nextBoolean()
    @GetMapping(value="/random")
    public ResponseEntity<String>rispostaACaso(){
        if(new Random().nextBoolean()== false){
            ResponseEntity.status(404).body("Il boolean è false");
            return ResponseEntity.badRequest().body("Il boolean is false");
        }return ResponseEntity.ok("Boolean is true");
    }
    @GetMapping(value="/meals")
    public ResponseEntity<List<Meal>> index(){
        return ResponseEntity.ok(
                mealService.getAllMeal());
    }

    @GetMapping(value = "/meal/{pasto}")
    public ResponseEntity<?> getMealListByMeal(@PathVariable("pasto") String pasto) {
        for (Meal x : mealDao.getMealList()) {
            if (x.getName().equals(pasto)){
                return ResponseEntity.ok(x);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/meal/description-match/{phrase}")
    public ResponseEntity<?> getMealListByDescription(@PathVariable("phrase") String phrase) {
        for (Meal x : mealDao.getMealList()) {
            if (x.getDescription().equals(phrase)){
                return ResponseEntity.ok(x);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "/meal/price")
    public ResponseEntity<?> getmealList(
            @RequestParam("min") double min,
            @RequestParam("max") double max) {
        List<Meal> listafiltrata= new ArrayList<>();
        for (Meal x : mealDao.getMealList()) {
            if (x.getPrice() >= min & x.getPrice() <= max) {
                listafiltrata.add(x);
            }
        }return ResponseEntity.ok(listafiltrata);
    }
    //Exercise 1: Create a PutMapping to add a new meal
    //
    //1 - Create a new endpoint "/meal" using the @PostMapping annotation.
    // 3 - In the method, add a RequestBody for the new Meal object.
    // 4 - Add the new meal to the list of meals.

    @GetMapping(value="/getlist")
    public ResponseEntity<List<Meal>> getMealList() {
        return ResponseEntity.ok(mealService.getAllMeal());
    }

    @PostMapping(value="/post/meal")
    public ResponseEntity<String> getMeal(
            @RequestBody Meal meal){
        this.mealDao.getMealList().add(meal);
        return ResponseEntity.ok("Aggiunto pasto");
    }

    //Exercise 2: Create a PostMapping to update a meal by name
//
//1 - Create a new endpoint "/meal/{name}" using the @PutMapping annotation.
// 2 - In the method, add a PathVariable for the name and a RequestBody for the updated Meal object.
// 3 - Update the meal with the corresponding name using the information from the RequestBody.
    @PutMapping(value="/meal/{name}")
    public ResponseEntity<String> updateMeal(
            @PathVariable("name") String name,
            @RequestBody Meal updateMeal){
        for(Meal x : mealDao.getMealList()){
            if(x.getName().equals(name)){
                x.setName(updateMeal.getName());
            }
        }
        return ResponseEntity.ok("Rinnovato nome");
    }

    //Exercise 3: Create a DeleteMapping to delete a meal by name
    //
    //1 - Create a new endpoint "/meal/{name}" using the @DeleteMapping annotation.
    // 2 - In the method, add a PathVariable for the name.
    // 3 - Delete the meal with the corresponding name.

    @DeleteMapping(value="/meal/{name}")
    public ResponseEntity<String> deleteName(
            @PathVariable("name") String name){
        mealService.deleteMeal("Impepata di cozze");
        return ResponseEntity.ok("Il nome è stato cancellato");
        }

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