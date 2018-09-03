package org.elsys.vending;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class EspressoVendingMachineTest {

    private EspressoVendingMachine vending;
    private Recipe recipe;

    @Before
    public void setUp() throws Exception {
        vending = new EspressoVendingMachine(
                Arrays.asList("coffee", "milk", "shugar"));
        vending.resupply();

        recipe = new Recipe("coffe with milk", 2.50);
        recipe.addIngredient("coffee", 2500);
        recipe.addIngredient("milk", 2500);
    }

    @Test
    public void testGetIngredientContainersInitial() {
        assertEquals(vending.getIngredientContainers().size(), 3);
    }

    @Test
    public void testHasEnoughIngredientSupply() {
        assertTrue(vending.hasEnoughIngredientSupply("milk", 2500));
        assertFalse(vending.hasEnoughIngredientSupply("coffee", 5100));
    }

    @Test(expected = RuntimeException.class)
    public void testHasEnoughIngredientSupplyThrows() {
        vending.hasEnoughIngredientSupply("cheese", 5);
    }

    @Test
    public void testGetIngredientSupply() {
        assertEquals(vending.getIngredientSupply("coffee"), 5000);
        vending.useIngredient("coffee", 2500);
        assertEquals(vending.getIngredientSupply("coffee"), 2500);
    }

    @Test(expected=RuntimeException.class)
    public void testGetBadIngredientSupplyThrows() {
        vending.getIngredientSupply("cheese");
    }
    
    @Test
    public void testResupplyContainer() {
        vending.useIngredient("coffee", 2500);
        assertEquals(vending.getIngredientSupply("coffee"), 2500);
        vending.resupplyContainer("coffee");
        assertEquals(vending.getIngredientSupply("coffee"), 5000);
    }
    
    @Test(expected=RuntimeException.class)
    public void testResupplyBadContainerThrows() {
        vending.resupplyContainer("cheese");
    }
    
    @Test
    public void testGetIngredientContainerCapacity() {
        assertEquals(5000, vending.getIngredientContainerCapacity("coffee"));
        assertEquals(5000, vending.getIngredientContainerCapacity("shugar"));
    }

    @Test(expected=RuntimeException.class)
    public void testGetBadIngredientContainerCapacityThrows() {
        assertEquals(5000, vending.getIngredientContainerCapacity("cheese"));
    }

    @Test
    public void testUseIngredient() {
        assertEquals(5000, vending.getIngredientSupply("coffee"));
        vending.useIngredient("coffee", 100);
        assertEquals(4900, vending.getIngredientSupply("coffee"));
    }
    
    @Test(expected=RuntimeException.class)
    public void testUseBadIngredientThrows() {
        vending.useIngredient("cheese", 100);
    }
    
    @Test
    public void testBrewRecipe() {
        vending.brewRecipe(recipe);
        assertEquals(vending.getIngredientSupply("coffee"), 2500);
        assertEquals(vending.getIngredientSupply("milk"), 2500);
        assertEquals(vending.getIngredientSupply("shugar"), 5000);
    }

    @Test
    public void testBrewRecipeTurnover() {
        assertEquals(vending.getTurnover(), 0.0, 0.01);
        
        vending.brewRecipe(recipe);
        assertEquals(vending.getTurnover(), 2.5, 0.01);
        
        vending.brewRecipe(recipe);
        assertEquals(vending.getTurnover(), 5.0, 0.01);
    }
    
    @Test(expected=RuntimeException.class)
    public void testBrewBadRecipeThrows() {
        Recipe rBad = new Recipe("cheese recipe", 2.50);
        rBad.addIngredient("cheese", 250);
        
        vending.brewRecipe(rBad);
    }
    
    @Test(expected=RuntimeException.class)
    public void testBrewRecipeNotEnoughSupplyThrows() {
        vending.brewRecipe(recipe);
        vending.brewRecipe(recipe);
        vending.brewRecipe(recipe);
    }
}
