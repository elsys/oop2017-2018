package org.elsys.vending;

import java.util.Collection;

public class EspressoVendingMachine {

    /*
     * Collection of all ingredients supported by the vending machine.
     */
    public EspressoVendingMachine(Collection<String> containers) {
    }

    /*
     * Returns the current turnover from all the sells after last resupply of the 
     * vending machine.
     */
    public double getTurnover() {
        return 0;
    }

    public void resupplyContainer(String ingredient) {
    }

    public void resupply() {
    }

    public boolean hasEnoughIngredientSupply(String ingredient, int amount) {
    	return false;
    }

    public Collection<String> getIngredientContainers() {
        return null;
    }
    
    public int getIngredientContainerCapacity(String ingredient) {
    	return 0;
    }

    public int getIngredientSupply(String ingredient) {
    	return 0;
    }

    public void useIngredient(String ingredient, int amount) {
    }

    public void brewRecipe(Recipe recipe) {
    }
}
