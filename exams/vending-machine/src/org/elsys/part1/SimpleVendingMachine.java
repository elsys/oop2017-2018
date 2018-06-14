package org.elsys.part1;

import java.util.Collection;

public class SimpleVendingMachine {

	public SimpleVendingMachine() {
	}

	/**
	 * Adds a product to the vending machine.
	 * 
	 * @param b
	 *            the Product to be added
	 * @return true if b was successfully added
	 */
	public boolean add(Product p) {
		return false;
	}

	/**
	 * Adds all products to the vending machine.
	 * 
	 * @param products to add
	 * @return
	 */
	public boolean addAll(Collection<Product> products) {
		return false;
	}

	/**
	 * Sells a product from the vending machine.
	 * 
	 * @param p
	 *            the Product to be sold
	 * @return change to return to the client
	 * 
	 * @throws {@link
	 *             RuntimeException} if product is not present in the vending
	 *             machine or if the inserted money are not enough
	 */
	public double sell(String product, double insertedMoney) {
		return 0;
	}

	/**
	 * Returns the collected money.
	 * 
	 * @return
	 */
	public double getRevenue() {
		return 0.0;
	}

	/**
	 * Returns the total count of products in the vending machine.
	 * 
	 * @return
	 */
	public int size() {
		return 0;
	}

	/**
	 * Removes all products from the vending machine.
	 */
	public void clear() {

	}

	/**
	 * Checks whether a Product is present in the vending machine.
	 * 
	 * @param b
	 *            the Product to check
	 * @return true if b is present
	 */
	public boolean contains(Product b) {
		return false;
	}

}