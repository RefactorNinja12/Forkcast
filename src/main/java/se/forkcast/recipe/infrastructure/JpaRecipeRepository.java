package se.forkcast.recipe.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;


import se.forkcast.recipe.domain.Recipe;
import se.forkcast.recipe.domain.RecipeRepository;

@Repository 
public class JpaRecipeRepository implements RecipeRepository {
    private final SpringDataRecipeRepository jpa; 

    public JpaRecipeRepository(SpringDataRecipeRepository jpa) {
        this.jpa = jpa; 
    }

    @Override
    public Recipe save(Recipe recipe) {
        return jpa.save(recipe);
    }

    @Override
    public Optional<Recipe> findById(Long id) {
        return jpa.findById(id);
    }

    @Override
    public List<Recipe> findAll() {
        return jpa.findAll();
    }

    

    @Override
    public void remove(Recipe recipe) {
        jpa.delete(recipe);
    }
}
