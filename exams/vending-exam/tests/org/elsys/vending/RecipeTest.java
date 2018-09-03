package org.elsys.vending;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class RecipeTest {

    private Recipe recipe = new Recipe("coffe with milk", 1.0);
    
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testAddIngredient() {
        recipe.addIngredient("coffe", 10);
        recipe.addIngredient("milk", 100);
        
        assertTrue(recipe.getIngredients().containsKey("coffe"));
        assertTrue(recipe.getIngredients().containsKey("milk"));
        
    }
    
    @Test(expected=RuntimeException.class)
    public void testDoubleAddIngredient() {
        recipe.addIngredient("coffe", 10);
        recipe.addIngredient("coffe", 10);
        
    }
    
    @Test
    public void testGetIngredientsReturnsCopy() {
        Map<String, Integer> ingredients = recipe.getIngredients();
        ingredients.put("coffe", 10);
        
        assertFalse(recipe.getIngredients().containsKey("coffe"));
    }

}
