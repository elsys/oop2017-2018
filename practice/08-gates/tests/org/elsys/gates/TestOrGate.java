package org.elsys.gates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestOrGate {

	private Wire in1;
	private Wire in2;
	private Wire out;

	private Gate orGate;

	@Before
	public void beforeEach() {
		in1 = new Wire("in1");
		in2 = new Wire("in2");

		out = new Wire("out");

		orGate = new OrGate(in1, in2, out);
		assertNotNull(orGate);
	}

	@Test
	public void testIn1FalseIn2False() {
		assertFalse(in1.getSignal());
		assertFalse(in2.getSignal());
		assertFalse(out.getSignal());
	}

	@Test
	public void outIn1TrueIn2False() {
		in1.setSignal(true);
		assertTrue(out.getSignal());
	}

	@Test
	public void outIn1FalseIn2True() {
		in2.setSignal(true);
		assertTrue(out.getSignal());
	}

	@Test
	public void outIn1TrueIn2True() throws InterruptedException {
		in1.setSignal(true);
		in2.setSignal(true);
		assertTrue(out.getSignal());
	}

}