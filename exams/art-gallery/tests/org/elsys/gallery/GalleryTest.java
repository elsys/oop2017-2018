package org.elsys.gallery;


import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

class GalleryTest {

	private Gallery gallery;

	@Before
	public void setUp() {
		gallery = new Gallery(10);
	}

	@Test
	public void testAdd() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 1)));
	}

	@Test(expected = RuntimeException.class)
	public void testAddForgery() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 1)));
		assertTrue(gallery.add(new Painting("B", "T", 1, 1)));
		assertTrue(gallery.add(new Painting("A", "U", 1, 1)));
		gallery.add(new Painting("A", "T", 3, 2));
	}

	@Test
	public void testContains() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 1)));
		assertTrue(gallery.contains(new Painting("A", "T", 2, 3)));
		assertFalse(gallery.contains(new Painting("B", "T", 1, 1)));
		assertFalse(gallery.contains(new Painting("A", "U", 1, 1)));
	}

	@Test
	public void testMonthlyCost() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 5)));
		assertTrue(gallery.add(new Painting("B", "U", 2, 5)));

		assertEquals(gallery.getMonthlyCost(), 1.0, 0.001);
	}

	@Test
	public void testRemainingMonthlyBudget() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 5)));
		assertTrue(gallery.add(new Painting("B", "U", 2, 5)));

		assertEquals(gallery.getRemainingMonthlyBudget(), 9.0, 0.001);
	}

	@Test
	public void testMonthlyPurchase() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 5)));
		assertTrue(gallery.add(new Painting("B", "U", 2, 5)));

		assertTrue(gallery.monthlyPurchase(Arrays.asList(new Painting("C", "V", 3, 9))));
		assertTrue(gallery.contains(new Painting("C", "V", 3, 9)));
	}

	@Test
	public void testMonthlyPurchaseUnsufficentBudget() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 5)));
		assertTrue(gallery.add(new Painting("B", "U", 2, 5)));

		try {
			gallery.monthlyPurchase(Arrays.asList(new Painting("C", "V", 3, 9),
					new Painting("C", "X", 4, 1)));
			assertTrue(false);
		} catch (RuntimeException e) {

		}
		
		assertFalse(gallery.contains(new Painting("C", "V", 3, 9)));
		assertFalse(gallery.contains(new Painting("C", "X", 3, 9)));
	}
}
