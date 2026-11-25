package se.forkcast.recipe.domain;





import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name = "recipeingredient")
public class RecipeIngredient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id; 

    @ManyToOne(optional = false)
    @JoinColumn(name = "recipe_id")
    private Recipe recipe; 

    @ManyToOne(optional = false)
    @JoinColumn(name = "ingredient_id")
    private Ingredient ingredient;  

    @Column(nullable = false)
    private double quantity;

    @Enumerated(EnumType.STRING)
    private UnitType unit; 

    protected RecipeIngredient(){}
    
    public RecipeIngredient(Recipe recipe, Ingredient ingredient, double quantity, UnitType unit){
        this.recipe = recipe;
        this.ingredient = ingredient;
        this.unit = unit; 
        this.quantity = quantity;
    }

    public Ingredient getIngrediens(){return ingredient;}
    public UnitType getUnit(){return unit;}
    public Long getId(){return id;}

    
}
