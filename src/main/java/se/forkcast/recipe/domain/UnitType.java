package se.forkcast.recipe.domain;

public enum UnitType {
    GRAM("g"),
    KILOGRAM("kg"),
    DECILITER("dl"),
    LITER("l");

    private final String symbol; 
     
    UnitType(String symbol){
        this.symbol = symbol; 
    }

    public String getSymbol(){return symbol; }
    
}
