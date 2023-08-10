package crud_operation_on_an_entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IngredientController {
    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @GetMapping(value="/insert-ingredient-test")
    public ResponseEntity<?>insertIngredientTest(){
        ingredientService.insertIngredientTest();
        return ResponseEntity.ok("Ingrediente inserito");
    }
}
