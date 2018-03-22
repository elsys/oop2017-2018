package org.elsys.gates;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestInverterGate {

	private Wire in;
	private Wire out;
	
	private Gate notGate;
	
	@BeforeEach
	void setUp() throws Exception {
		in = new Wire();
		out = new Wire();
		notGate = new InverterGate(in, out);
	}

	@Test
	void testInFalse() {
		in.setSignal(true);
		in.setSignal(false);
		assertTrue(out.getSignal());
	}

	@Test
	void testInTrue() {
		in.setSignal(true);
		assertFalse(out.getSignal());
	}
}
