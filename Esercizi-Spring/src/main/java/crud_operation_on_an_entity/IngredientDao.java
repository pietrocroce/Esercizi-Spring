package crud_operation_on_an_entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientDao extends JpaRepository<Ingredient, Long> {}
