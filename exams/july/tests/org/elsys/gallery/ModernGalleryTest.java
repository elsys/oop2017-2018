package org.elsys.gallery;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ModernGalleryTest {
	private ModernGallery gallery;

	@Before
	public void setUp() {
		gallery = new ModernGallery(10);
	}

	@Test
	public void testAdd() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1800, 2, 1)));
	}

	@Test(expected = RuntimeException.class)
	public void testAddForgery() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1800, 2, 1)));
		assertTrue(gallery.add(new Sculpture("B", "T", 1800, 2, 1)));
		assertTrue(gallery.add(new Sculpture("A", "U", 1800, 2, 1)));
		gallery.add(new Sculpture("A", "T", 1800, 2, 2));
	}

	@Test(expected = RuntimeException.class)
	public void testAddBadYear() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1799, 2, 1)));
	}
	
	@Test
	public void testContains() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1800, 2, 1)));
		assertTrue(gallery.contains(new Sculpture("A", "T", 1800, 2, 3)));
		assertFalse(gallery.contains(new Sculpture("B", "T", 1800, 2, 1)));
		assertFalse(gallery.contains(new Sculpture("A", "U", 1800, 2, 1)));
	}

	@Test
	public void testMonthlyCost() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1800, 2, 5)));
		assertTrue(gallery.add(new Sculpture("B", "U", 1800, 2, 5)));

		assertEquals(gallery.getMonthlyCost(), 0.8, 0.001);
	}

	@Test
	public void testRemainingMonthlyBudget() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1800, 2, 5)));
		assertTrue(gallery.add(new Sculpture("B", "U", 1800, 2, 5)));

		assertEquals(gallery.getRemainingMonthlyBudget(), 9.2, 0.001);
	}

	@Test
	public void testMonthlyPurchase() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1800, 2, 5)));
		assertTrue(gallery.add(new Sculpture("B", "U", 1800, 2, 5)));

		assertTrue(gallery.monthlyPurchase(Arrays.asList(new Sculpture("C", "V", 1900, 2, 9))));
		assertTrue(gallery.contains(new Sculpture("C", "V", 1900, 2, 9)));
	}

	@Test(expected = RuntimeException.class)
	public void testMonthlyPurchaseUnsufficentBudget() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1800, 2, 5)));
		assertTrue(gallery.add(new Sculpture("B", "U", 1800, 2, 5)));

		gallery.monthlyPurchase(
				Arrays.asList(new Sculpture("C", "V", 1900, 2, 9), new Sculpture("C", "X", 1901, 2, 1)));

		assertFalse(gallery.contains(new Sculpture("C", "V", 3, 2, 9)));
		assertFalse(gallery.contains(new Sculpture("C", "X", 3, 2, 9)));
	}

	@Test(expected = RuntimeException.class)
	public void testMonthlyOldPainting() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1800, 2, 5)));
		assertTrue(gallery.add(new Sculpture("B", "U", 1800, 2, 5)));

		gallery.monthlyPurchase(
				Arrays.asList(new Sculpture("C", "V", 1800, 2, 9), 
						new Sculpture("C", "X", 1799, 2, 1)));

		assertFalse(gallery.contains(new Sculpture("C", "V", 1800, 2, 9)));
		assertFalse(gallery.contains(new Sculpture("C", "X", 1799, 2, 9)));
	}

	@Test
	public void testGetWorksOf() {
		assertTrue(gallery.add(new Sculpture("A", "T", 1800, 2, 5)));
		assertTrue(gallery.add(new Sculpture("A", "U", 1800, 2, 6)));
		assertTrue(gallery.add(new Sculpture("A", "V", 1800, 2, 7)));

		List<PieceOfArt> result = gallery.getWorksOf("A");
		assertEquals(3, result.size());

		assertEquals("V", result.get(0).getTitle());
		assertEquals("U", result.get(1).getTitle());
		assertEquals("T", result.get(2).getTitle());
	}
}
