package se.forkcast.recipe.domain;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository {

    Ingredient save(Ingredient ingredient);
    void remove(Ingredient ingredient);
    List<Ingredient> findAll();
    Optional<Ingredient> findById(Long id);

}
