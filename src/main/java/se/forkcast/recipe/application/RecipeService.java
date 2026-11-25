package se.forkcast.recipe.application;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import se.forkcast.recipe.domain.Recipe;
import se.forkcast.recipe.domain.RecipeRepository;


@Service 
public class RecipeService {
    private final RecipeRepository repo; 

    public RecipeService(RecipeRepository repo) {
        this.repo = repo; 
    }

    public Recipe findById(Long id){
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Recipe " + id + "Not found")); 
    }
    public List<Recipe> findAll(){
        return repo.findAll();
    }
    public Recipe addRecipe(String name, String instruction){
        var recipe = new Recipe(name, instruction);
        return repo.save(recipe);
    }
    @Transactional 
    public void updateRecipe(Long id, String name, String instruction){
        Recipe recipeUpdate = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Recipe " + id + "Not found")); 
        recipeUpdate.setName(name);
        recipeUpdate.setInstruction(instruction);
    }
    public void remove(Long id){
        Recipe recipe = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Recipe " + id + "Not found")); 
        repo.remove(recipe);
    }

}
