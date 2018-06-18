package org.elsys.gallery;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Gallery {

	public Gallery(int budget) {
	}

	/**
	 *
	 * @return gallery budget.
	 */
	public int getBudget() {
		return 0;
	}

	/**
	 * Montly cost for running the gallery - 10% of the total price of all
	 * paintings.
	 * 
	 * @return
	 */
	public double getMonthlyCost() {
		return 0;
	}

	/**
	 * Calculates the monthly budget that could be spend on buying new paintings.
	 * 
	 * @return
	 */
	public double getRemainingMonthlyBudget() {
		return 0;
	}

	/**
	 * Add painting to the gallery collection.
	 * 
	 * If there is a painting in gallery collection with the same author and name,
	 * throws RuntimeException because of forgery suspected.
	 * 
	 * @param painting
	 *            - painting to be added
	 * @return true if p was successfully added, false otherwise.
	 */
	public boolean add(Painting painting) {
		return false;
	}

	public boolean addAll(Collection<Painting> paintings) {
		return false;
	}

	
	
	/**
	 * Purchases paintings for the gallery collection.
	 * 
	 * If there is a painting in gallery collection with the same author and name,
	 * throws RuntimeException because of forgery suspected.
	 * 
	 * If the monthly budget is not enough to buy all the paintings throws RuntimeException.
	 * 
	 * @param paintings
	 *            - paintings to buy
	 * @return true if all are paintigns are purchased.
	 */
	public boolean monthlyPurchase(Collection<Painting> paintings) {
		return false;
	}
	
	public int size() {
		return 0;
	}
	
	/**
	 * If there is a painting in gallery collection with the same artist and title,
	 * returns true. Otherwise returns false
	 * 
	 * @param painting
	 * @return
	 */
	public boolean contains(Painting painting) {
		return false;
	}
}
