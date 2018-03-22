package org.elsys.gates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestNotGate {

	private Wire in;
	private Wire out;
	private Gate gate;
	
	@Before
	public void setUp() throws Exception {
		in = new Wire();
		out = new Wire();
		gate = new InverterGate(in, out);
		in.setSignal(true);
		in.setSignal(false);
	}

	@Test
	public void testInTrue() {
		in.setSignal(true);
		assertFalse(out.getSignal());
	}
	
	@Test
	public void testInFalse() {
		in.setSignal(false);
		assertTrue(out.getSignal());
	}

}
