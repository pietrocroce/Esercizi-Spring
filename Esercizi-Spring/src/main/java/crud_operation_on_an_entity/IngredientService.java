package crud_operation_on_an_entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientService {
    private IngredientDao ingredientDao;

    @Autowired

    public IngredientService(IngredientDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }
    public void insertIngredientTest(){
        ingredientDao.save(new Ingredient(1L,"asparago",true,true,true,true));
    }
}
