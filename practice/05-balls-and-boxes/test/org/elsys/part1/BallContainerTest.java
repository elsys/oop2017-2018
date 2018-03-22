package org.elsys.part1;

import static org.junit.Assert.*;

import org.elsys.part1.Ball;
import org.elsys.part1.BallContainer;
import org.junit.Test;

public class BallContainerTest {

	@Test
	public void testAdd() {
		BallContainer container = new BallContainer();
		Ball ball1 = new Ball(10.1);
		Ball ball2 = new Ball(10.2);

		assertTrue(container.add(ball1));
		assertTrue(container.add(ball2));
	}

	@Test
	public void testRemove() {
		BallContainer container = new BallContainer();
		Ball ball1 = new Ball(10.1);

		container.add(ball1);
		assertTrue(container.remove(ball1));
		assertFalse(container.contains(ball1));
	}

	@Test
	public void testContains() {
		BallContainer container = new BallContainer();
		Ball ball1 = new Ball(10.1);

		container.add(ball1);
		assertTrue(container.contains(ball1));
		assertTrue(container.contains(new Ball(10.1)));
	}

	@Test
	public void testVolume() {
		BallContainer container = new BallContainer();

		container.add(new Ball(2.01));
		container.add(new Ball(2.0));
		assertEquals(4.01,
				container.getVolume(), 0.01);
	}

}
