package org.elsys.vending;

import java.util.Map;

public class Recipe {

    public Recipe(String name, double price) {
    }

    public double getPrice() {
    	return 0;
    }
    
    public String getName() {
    	return null;
    }

    /*
     * Should add an ingredient into the recipe. If given ingredient is added
     * twice a RuntimeException should be thrown.
     */
    public void addIngredient(String name, int amount) {
    }

    /*
     * Should return a copy of the ingredients in the recipe.
     */
    public Map<String, Integer> getIngredients() {
        return null;
    }
}
