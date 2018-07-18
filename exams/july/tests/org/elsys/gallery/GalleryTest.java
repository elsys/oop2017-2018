package org.elsys.gallery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class GalleryTest {

	private Gallery gallery;

	@Before
	public void setUp() {
		gallery = new Gallery(10);
	}

	@Test
	public void testAdd() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1, 2, 1)));
	}

	@Test(expected = RuntimeException.class)
	public void testAddForgery() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1, 2, 1)));
		assertTrue(gallery.add(new Sculpture("B", "T", 1, 2, 1)));
		assertTrue(gallery.add(new Sculpture("A", "U", 1, 2, 1)));
		gallery.add(new Sculpture("A", "T", 3, 2, 2));
	}

	@Test
	public void testContains() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1, 2, 1)));
		assertTrue(gallery.contains(new Sculpture("A", "T", 2, 2, 3)));
		assertFalse(gallery.contains(new Sculpture("B", "T", 1, 2, 1)));
		assertFalse(gallery.contains(new Sculpture("A", "U", 1, 2, 1)));
	}

	@Test
	public void testMonthlyCost() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1, 2, 5)));
		assertTrue(gallery.add(new Sculpture("B", "U", 2, 2, 5)));

		assertEquals(gallery.getMonthlyCost(), 1.0, 0.001);
	}

	@Test
	public void testRemainingMonthlyBudget() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1, 2, 5)));
		assertTrue(gallery.add(new Sculpture("B", "U", 2, 2, 5)));

		assertEquals(gallery.getRemainingMonthlyBudget(), 9.0, 0.001);
	}

	@Test
	public void testMonthlyPurchase() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1, 2, 5)));
		assertTrue(gallery.add(new Sculpture("B", "U", 2, 2, 5)));

		assertTrue(gallery.monthlyPurchase(Arrays.asList(new Sculpture("C", "V", 3, 2, 9))));
		assertTrue(gallery.contains(new Sculpture("C", "V", 3, 2, 9)));
	}

	@Test(expected = RuntimeException.class)
	public void testMonthlyPurchaseUnsufficentBudget() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1, 2, 5)));
		assertTrue(gallery.add(new Sculpture("B", "U", 2, 2, 5)));

		gallery.monthlyPurchase(Arrays.asList(new Sculpture("C", "V", 3, 2, 9), new Sculpture("C", "X", 4, 2, 1)));

		assertFalse(gallery.contains(new Sculpture("C", "V", 3, 2, 9)));
		assertFalse(gallery.contains(new Sculpture("C", "X", 3, 2, 9)));
	}

	@Test
	public void testGetWorksByWeight() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1, 1, 5)));
		assertTrue(gallery.add(new Sculpture("B", "U", 2, 2, 5)));
		assertTrue(gallery.add(new Sculpture("B", "V", 2, 3, 5)));
		assertTrue(gallery.add(new Sculpture("B", "W", 2, 4, 5)));
		
		assertEquals(gallery.getWorksByWeight(1.5, 3.5).size(), 2);
	}

}
