package com.example.Esercizi.Spring.Dao;

import com.example.Esercizi.Spring.Meal;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class MealDao {

    private List<Meal> mealList = Arrays.asList(
            new Meal("impepata di cozze", "sugo di cozze", 6.00),
            new Meal("tagliatelle al ragu", "pasta lunga con ragu di cinghiale", 12.00),
            new Meal("orata all'acqua pazza", "orata cotta al forno con limone e pomodorini", 13.00),
            new Meal("proscitto e melone", "melone cantalupo con con prosciutto di parma", 6.00),
            new Meal("parmigiana di melanzane", "melanzane con formaggio,pomodoro", 8.00),
            new Meal("coniglio all'ischitana", "coniglio cotto con erbe selvatiche e pomodorini", 20.00),
            new Meal("sorbetto al limone", "dolce al limone", 5.00));

    public List<Meal> getMealList() {
        return mealList;
    }
}