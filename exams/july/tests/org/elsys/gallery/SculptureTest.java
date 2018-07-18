package org.elsys.gallery;

import org.junit.Test;

public class SculptureTest {

	
	@Test
	public void testSculptureCreate() {
		new Sculpture("A", "T", 1, 2, 5);
	}
	
	@Test(expected=RuntimeException.class)
	public void testSculptureCreateBadYearLow() {
		new Sculpture("A", "T", -1001, 2, 5);
	}

	@Test(expected=RuntimeException.class)
	public void testSculptureCreateBadYearHight() {
		new Sculpture("A", "T", 2019, 2, 5);
	}
	
	@Test(expected=RuntimeException.class)
	public void testSculptureCreateBadWeight() {
		new Sculpture("A", "T", 2018, 0, 5);
	}

	@Test(expected=RuntimeException.class)
	public void testSculptureCreateBadPrice() {
		new Sculpture("A", "T", 2018, 1, 0);
	}
}
