package se.forkcast.recipe.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import se.forkcast.recipe.domain.Ingredient;
import se.forkcast.recipe.domain.IngredientRepository;


@Service 
public class IngredientService {
    
    private final IngredientRepository repo; 
    
    public IngredientService(IngredientRepository repo) {
        this.repo = repo; 
    }

    public Ingredient addIngredient(String name)
    {
        Ingredient ingredient = new Ingredient(name);
        return repo.save(ingredient);
    }
    public Ingredient findById(Long id){
        return repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Ingredient " + id + "Not found"));
    }
    public List<Ingredient> findAll(){
        return repo.findAll();
    }
    @Transactional 
    public void updateIngredient(Long id, String name){
        Ingredient updateIngredient = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Ingredient " + id + "Not found"));
        updateIngredient.setName(name);
    }
    public void remove(Long id){
        Ingredient ingredient = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Ingredien " + id + "Not Found")); 
        repo.remove(ingredient);
    }
}
