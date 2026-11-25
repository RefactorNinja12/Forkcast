package se.forkcast.mealplan.domain;

import java.time.DayOfWeek;

import jakarta.persistence.*;


@Entity 
@Table(name = "mealplanrecipe")

public class MealplanRecipe {
    @Id 
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne(optional = false)
    @JoinColumn (name = "mealplan_id")
    private Mealplan mealplan; 

    
    @Column(name = "recipe_id", nullable = false)
    private Long recipeId;  

    @Enumerated(EnumType.STRING)
    private DayOfWeek day;
    
    protected MealplanRecipe(){}

    public MealplanRecipe(Mealplan mealplan, Long recipeId, DayOfWeek day){
        this.mealplan = mealplan; 
        this.recipeId = recipeId;
        this.day = day; 
    }

    public Long getRecipeId(){return recipeId;}
    public DayOfWeek getDay(){return day;}
    

    
}
