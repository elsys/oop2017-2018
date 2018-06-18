package org.elsys.gallery;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ModernGalleryTest {
	private ModernGallery gallery;

	@BeforeEach
	public void setUp() {
		gallery = new ModernGallery(10);
	}

	@Test
	public void testAdd() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 1)));
	}

	@Test
	public void testAddForgery() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 1)));
		assertTrue(gallery.add(new Painting("B", "T", 1, 1)));
		assertTrue(gallery.add(new Painting("A", "U", 1, 1)));
		assertThrows(RuntimeException.class, () -> {
			gallery.add(new Painting("A", "T", 3, 2));
		});
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

		assertEquals(gallery.getMonthlyCost(), 0.8, 0.001);
	}

	@Test
	public void testRemainingMonthlyBudget() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 5)));
		assertTrue(gallery.add(new Painting("B", "U", 2, 5)));

		assertEquals(gallery.getRemainingMonthlyBudget(), 9.2, 0.001);
	}

	@Test
	public void testMonthlyPurchase() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 5)));
		assertTrue(gallery.add(new Painting("B", "U", 2, 5)));

		assertTrue(
				gallery.monthlyPurchase(Arrays.asList(new Painting("C", "V", 1900, 9))));
		assertTrue(gallery.contains(new Painting("C", "V", 1900, 9)));
	}

	@Test
	public void testMonthlyPurchaseUnsufficentBudget() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 5)));
		assertTrue(gallery.add(new Painting("B", "U", 2, 5)));

		assertThrows(RuntimeException.class, () -> {
			gallery.monthlyPurchase(Arrays.asList(new Painting("C", "V", 1900, 9),
					new Painting("C", "X", 1901, 1)));
		});

		assertFalse(gallery.contains(new Painting("C", "V", 3, 9)));
		assertFalse(gallery.contains(new Painting("C", "X", 3, 9)));
	}

	@Test
	public void testMonthlyOldPainting() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 5)));
		assertTrue(gallery.add(new Painting("B", "U", 2, 5)));

		assertThrows(RuntimeException.class, () -> {
			gallery.monthlyPurchase(Arrays.asList(new Painting("C", "V", 1900, 9),
					new Painting("C", "X", 1899, 1)));
		});

		assertFalse(gallery.contains(new Painting("C", "V", 3, 9)));
		assertFalse(gallery.contains(new Painting("C", "X", 3, 9)));
	}

	@Test
	public void testGetPaintingsOf() {
		assertTrue(gallery.add(new Painting("A", "T", 1, 5)));
		assertTrue(gallery.add(new Painting("A", "U", 1, 6)));
		assertTrue(gallery.add(new Painting("A", "V", 1, 7)));

		List<Painting> result = gallery.getPaintingsOf("A");
		assertEquals(3, result.size());
		
		assertEquals("V", result.get(0).getTitle());
		assertEquals("U", result.get(1).getTitle());
		assertEquals("T", result.get(2).getTitle());
	}
}
