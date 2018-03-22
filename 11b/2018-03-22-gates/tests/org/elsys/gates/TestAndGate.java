package org.elsys.gates;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestAndGate {

	private Wire in1;
	private Wire in2;
	private Wire out;
	
	private Gate andGate;
	
	@BeforeEach
	public void setUp() throws Exception {
		in1 = new Wire();
		in2 = new Wire();
		out = new Wire();
		
		andGate = new AndGate(in1, in2, out);
	}

	@Test
	public void testIn1TrueIn2False() {
		in1.setSignal(true);
		in2.setSignal(false);
		
		assertFalse(out.getSignal());
	}
	
	@Test
	public void testIn1TrueIn2True() {
		in1.setSignal(true);
		in2.setSignal(true);
		
		assertTrue(out.getSignal());
		
	}

}
