package org.elsys.gates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCompositeXorGate {

	private Wire in1;
	private Wire in2;
	private Wire out;

	private Gate xorGate;

	@Before
	public void beforeEach() {
		in1 = new Wire("in1");
		in2 = new Wire("in2");

		out = new Wire("out");

		xorGate = GateFactory.makeXorGate(in1, in2, out);
		assertNotNull(xorGate);
	}
	
	
	@Test
	public void test() {
		assertFalse(out.getSignal());
	}

	@Test
	public void testTrue1() {
		in1.setSignal(true);
		assertTrue(out.getSignal());
	}

	@Test
	public void testTrue2() {
		in2.setSignal(true);
		assertTrue(out.getSignal());
	}

	@Test
	public void testAllTrue() {
		in1.setSignal(true);
		in2.setSignal(true);
		assertFalse(out.getSignal());
	}
	
}
