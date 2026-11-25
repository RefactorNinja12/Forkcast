package se.forkcast.recipe.domain;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;


@Entity 
@Table (name = "recipe")
public class Recipe {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column (nullable = false)
    private String name; 

    private String instruction;
    
    private LocalDate createdAt;
    protected Recipe(){}

    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RecipeIngredient> ingredients = new ArrayList<>();


    public Recipe(String name, String instruction){
        this.name = name;
        this.instruction = instruction; 
        this.createdAt = LocalDate.now();
        
    }

    public String getName(){return name;}
    public String getInstruction(){return instruction;}
    public Long getId(){return id;}
    public void setName(String name){this.name = name;}
    public void setInstruction(String instruction){this.instruction = instruction;}
    



    public List<RecipeIngredient> getIngredient(){
        return Collections.unmodifiableList(ingredients);
    }

    public void addIngredient(Ingredient ingredient, double quantity, UnitType unit){
        ingredients.add(new RecipeIngredient(this, ingredient, quantity, unit ));
    }

   

}
