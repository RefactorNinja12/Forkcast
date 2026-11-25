package se.forkcast.recipe.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import se.forkcast.recipe.domain.Ingredient;

public interface SpringDataIngredientRepository extends JpaRepository<Ingredient, Long> {
    
}
