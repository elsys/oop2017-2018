package org.elsys.gates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestNandXorGate {

	private Wire in1;
	private Wire in2;
	private Wire out;

	private Gate xorGate;

	@Before
	public void beforeEach() {
		in1 = new Wire("in1");
		in2 = new Wire("in2");

		out = new Wire("out");

		xorGate = NandFactory.makeXorGate(in1, in2, out);
		assertNotNull(xorGate);
	}

	@Test
	public void testIn1FalseIn2False() {
		assertFalse(in1.getSignal());
		assertFalse(in2.getSignal());
		assertFalse(out.getSignal());
	}

	@Test
	public void testIn1TrueIn2False() {
		in1.setSignal(true);
		assertTrue(out.getSignal());
	}

	@Test
	public void testIn1FalseIn2True() {
		in2.setSignal(true);
		assertTrue(out.getSignal());
	}

	@Test
	public void testIn1TrueIn2True() {
		in1.setSignal(true);
		in2.setSignal(true);
		assertFalse(out.getSignal());
	}
}