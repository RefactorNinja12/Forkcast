package se.forkcast.recipe.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import se.forkcast.recipe.domain.Ingredient;
import se.forkcast.recipe.domain.IngredientRepository;
@Repository 
public class JpaIngredientRepository implements IngredientRepository {

    private final SpringDataIngredientRepository jpa; 

    public JpaIngredientRepository(SpringDataIngredientRepository jpa) {
        this.jpa = jpa; 
    }
    @Override
    public Ingredient save(Ingredient ingredient) {
        return jpa.save(ingredient);
    }

    @Override
    public void remove(Ingredient ingredient) {
        jpa.delete(ingredient);
    }

    @Override
    public List<Ingredient> findAll() {
        return jpa.findAll();
    }

    @Override
    public Optional<Ingredient> findById(Long id) {
        return jpa.findById(id);
    }
    
}
