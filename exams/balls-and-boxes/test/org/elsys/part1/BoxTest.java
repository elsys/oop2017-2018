package org.elsys.part1;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.elsys.part1.Ball;
import org.elsys.part1.Box;
import org.junit.Test;

public class BoxTest {

	@Test(expected = RuntimeException.class)
	public void testMaxCapacity() {
		Box box = new Box(10);
		assertTrue(box.add(new Ball(5, "football")));
		box.add(new Ball(6, "football"));
	}

	@Test
	public void testNull() {
		Box box = new Box(10);
		assertFalse(box.add(null));
	}

	@Test
	public void testIterator() {
		Box box = new Box(10);
		box.add(new Ball(1, "football"));
		box.add(new Ball(3, "football"));
		box.add(new Ball(2, "football"));

		Iterator<Ball> iter = box.getBallsFromBiggest();
		assertEquals(3, iter.next().getVolume(), 0.01);
		assertEquals(2, iter.next().getVolume(), 0.01);
		assertEquals(1, iter.next().getVolume(), 0.01);
		assertFalse(iter.hasNext());
	}
}
