package org.elsys.part1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class AdvancedVendingMachineTest {

	private AdvancedVendingMachine vendingMachine;

	@Before
	public void before() {
		vendingMachine = new AdvancedVendingMachine();
	}

	@Test
	public void testAdd() {
		assertTrue(vendingMachine.add(new Product("Jellybean", 10.1)));
		assertTrue(vendingMachine.add(new Product("Cola", 10.2)));
	}

	@Test
	public void testSell() {
		Product product = new Product("Corny", 10.1);
		vendingMachine.add(product);
		assertEquals(9.9, vendingMachine.sell("Corny", 20), 0.001);
		assertFalse(vendingMachine.contains(product));
		assertEquals(10.1, vendingMachine.getRevenue(), 0.001);
	}

	@Test(expected = RuntimeException.class)
	public void testSellProductNotExisting() {
		vendingMachine.sell("Corny", 20);
	}

	@Test(expected = RuntimeException.class)
	public void testSellNotEnoughMoney() {
		Product product = new Product("Corny", 10.1);
		vendingMachine.add(product);
		vendingMachine.sell("Corny", 10);
	}

	@Test
	public void testContains() {
		SimpleVendingMachine vendingMachine = new SimpleVendingMachine();
		Product product1 = new Product("Cola", 10.1);

		vendingMachine.add(product1);
		assertTrue(vendingMachine.contains(product1));
		assertTrue(vendingMachine.contains(new Product("Cola", 10.1)));
	}

	@Test
	public void testChangeProductPrice() {
		vendingMachine.add(new Product("Corny", 10.1));
		vendingMachine.add(new Product("Corny", 10.1));
		vendingMachine.add(new Product("Cola", 11.1));
		vendingMachine.changePriceOf("Corny", 7.5);

		vendingMachine.contains(new Product("Corny", 7.5));
		assertEquals(0.5, vendingMachine.sell("Corny", 8), 0.001);
	}

}
