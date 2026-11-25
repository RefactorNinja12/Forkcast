package se.forkcast.mealplan.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jakarta.persistence.*;

@Entity 
@Table(name = "mealplan")
public class Mealplan {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id; 

    @Column(nullable = false)
    private int weekNumber;
    private String description;

    protected Mealplan(){}

     @OneToMany(mappedBy = "mealplan", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MealplanRecipe> mealplanRecipe = new ArrayList<>();
    
    public Mealplan(int weekNumber, String description){
        this.weekNumber = weekNumber;
        this.description = description;
    }

    public Long getId() {return id;}
    public int getWeekNumber() {return weekNumber;}
    public String getDescription() {return description;}
    public List<MealplanRecipe> getRecipes(){
        return Collections.unmodifiableList(mealplanRecipe);
    }

    public void setWeekNumber(int weekNumber){this.weekNumber = weekNumber;}
    public void setDescription(String description){this.description = description;}

    public void planRecipe(Long recipeId, DayOfWeek day){
        mealplanRecipe.add(new MealplanRecipe(this, recipeId, day));
    }

   

    
}
