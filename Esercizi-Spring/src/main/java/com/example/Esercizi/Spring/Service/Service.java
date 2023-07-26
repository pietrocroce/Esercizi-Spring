package com.example.Esercizi.Spring.Service;

import com.example.Esercizi.Spring.Dao.MealDao;
import com.example.Esercizi.Spring.Meal;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

@org.springframework.stereotype.Service

public class Service {
    @Autowired
    private MealDao mealDao;
    public void addMeal(Meal meal) {
        this.mealDao.getMealList().add(meal);
    }

    public void deleteMeal(String x) {
        for (Meal meal : mealDao.getMealList()) {
            if (meal.getName().equals(x)) {
                mealDao.getMealList().remove(meal);
            }
        }
    }

    public void updateMeal(String y) {
        for (Meal meal : mealDao.getMealList()) {
            if (meal.getName().equals(y)) {
                mealDao.getMealList().remove(meal.getName());
                meal.setName(y);
            }
        }
    }
    public List<Meal> getAllMeal(){
        return this.mealDao.getMealList();
    }
}
