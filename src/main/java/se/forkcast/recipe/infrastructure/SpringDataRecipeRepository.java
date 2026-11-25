package se.forkcast.recipe.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

import se.forkcast.recipe.domain.Recipe;

public interface SpringDataRecipeRepository extends JpaRepository<Recipe, Long>{
    
}
