package org.elsys.vending;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SmartVendingMachineTest {

    private static class MockVendingMachine extends SmartVendingMachine {
        private boolean notificationMock;

        public MockVendingMachine(List<String> containers) {
            super(containers);
            notificationMock = false;
        }

        public void notifySupport() {
            super.notifySupport();
            notificationMock = true;
        }

        public boolean checkNotificationMock() {
            return notificationMock;
        }

        public void resetNotificationMock() {
            notificationMock = false;
        }
    }

    private MockVendingMachine vending;
    private Recipe recipe;
    
    @Before
    public void setUp() throws Exception {
        vending = new MockVendingMachine(
                Arrays.asList("coffee", "milk", "shugar"));
        vending.resupply();

        recipe = new Recipe("coffe with milk", 2.50);
        recipe.addIngredient("coffee", 50);
        recipe.addIngredient("milk", 100);
    }

    @Test
    public void testNotifySupport() {
        vending.brewRecipe(recipe);
        assertFalse(vending.checkNotificationMock());
        vending.useIngredient("coffee", 4500);
        vending.brewRecipe(recipe);
        assertTrue(vending.checkNotificationMock());
    }

    @Test
    public void testMissingDoubleNotifySupport() {
        vending.useIngredient("coffee", 4000);
        vending.brewRecipe(recipe);
        assertTrue(vending.checkNotificationMock());
        vending.resetNotificationMock();
        vending.brewRecipe(recipe);
        assertFalse(vending.checkNotificationMock());
    }

    @Test
    public void testNotifySupportAfterResupply() {
        vending.useIngredient("coffee", 4000);
        vending.brewRecipe(recipe);
        assertTrue(vending.checkNotificationMock());
        vending.resetNotificationMock();
        vending.brewRecipe(recipe);
        assertFalse(vending.checkNotificationMock());

        vending.resupply();
        vending.useIngredient("coffee", 4000);
        vending.brewRecipe(recipe);
        assertTrue(vending.checkNotificationMock());

    }

    @Test
    public void testNotifySupport10() {
        vending.useIngredient("coffee", 4000);
        vending.brewRecipe(recipe);
        assertTrue(vending.checkNotificationMock());
        vending.resetNotificationMock();
        vending.brewRecipe(recipe);
        assertFalse(vending.checkNotificationMock());
        
        vending.useIngredient("coffee", 500);
        vending.brewRecipe(recipe);
        assertTrue(vending.checkNotificationMock());
        
        vending.resetNotificationMock();
        vending.brewRecipe(recipe);
        assertFalse(vending.checkNotificationMock());
    }
    
}
