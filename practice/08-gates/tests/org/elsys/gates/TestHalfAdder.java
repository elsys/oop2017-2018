package org.elsys.gates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestHalfAdder {

	private Wire a;
	private Wire b;
	private Wire s;
	private Wire c;

	private Gate halfAdder;

	@Before
	public void beforeEach() {
		a = new Wire("A");
		b = new Wire("B");

		s = new Wire("sum");
		c = new Wire("carry");

		halfAdder = GateFactory.makeHalfAdder(a, b, s, c);
		assertNotNull(halfAdder);
	}

	@Test
	public void test() {
		assertFalse(s.getSignal());
		assertFalse(c.getSignal());
	}

	@Test
	public void testTrueAFalseB() {
		a.setSignal(true);
		b.setSignal(false);
		
		assertTrue(s.getSignal());
		assertFalse(c.getSignal());
	}
	
	@Test
	public void testFalseATrueB() {
		a.setSignal(false);
		b.setSignal(true);
		
		assertTrue(s.getSignal());
		assertFalse(c.getSignal());
	}

	@Test
	public void testTrueATrueB() {
		a.setSignal(true);
		b.setSignal(true);
		
		assertFalse(s.getSignal());
		assertTrue(c.getSignal());
	}
	
}
