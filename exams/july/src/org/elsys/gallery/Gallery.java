package org.elsys.gallery;

import java.util.Collection;

public class Gallery {

	public Gallery(int budget) {
	}

	/**
	 *
	 * @return gallery budget.
	 */
	public int getBudget() {
	}

	/**
	 * Montly cost for running the gallery - 10% of the total price of all
	 * art works.
	 * 
	 * @return
	 */
	public double getMonthlyCost() {
	}

	/**
	 * Calculates the monthly budget that could be spend on buying new art works.
	 * 
	 * @return
	 */
	public double getRemainingMonthlyBudget() {
	}

	/**
	 * Add art works to the gallery collection.
	 * 
	 * If there is a piece of art in gallery collection with the same author, name and
	 * year of creation,
	 * throws RuntimeException because of forgery suspected.
	 * 
	 * @param artWork
	 *            - piece of art to be added
	 * @return true if p was successfully added, false otherwise.
	 */
	public boolean add(PieceOfArt artWork) {
	}

	public boolean addAll(Collection<PieceOfArt> artWorks) {
	}

	public boolean monthlyPurchase(Collection<PieceOfArt> artWorks) {
	}
	
	public int size() {
	}
	
	/**
	 * If there is a painting in gallery collection with the same artist and title,
	 * returns true. Otherwise returns false
	 * 
	 * @param painting
	 * @return
	 */
	public boolean contains(PieceOfArt painting) {
	}
	/**
	 * Returns collection of works from the gallery, which weight is between
	 * minWeight and maxWeight.
	 * 
	 * @param minWeight
	 * @param maxWeight
	 * @return
	 */
	public Collection<PieceOfArt> getWorksByWeight(double minWeight, double maxWeight) {
	}
}
