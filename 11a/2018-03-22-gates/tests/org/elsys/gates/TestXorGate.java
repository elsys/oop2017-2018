package org.elsys.gates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestXorGate {

	private Wire in1;
	private Wire in2;
	private Wire out;
	
	private Gate gate;
	
	@Before
	public void setUp() throws Exception {
		in1 = new Wire();
		in2 = new Wire();
		out = new Wire();
		
		gate = GateFactory.makeXor(in1, in2, out);
	}

	@Test
	public void testIn1TrueIn2False() {
		in1.setSignal(true);
		in2.setSignal(false);
		
		assertTrue(out.getSignal());
	}

	@Test
	public void testIn1TrueIn2True() {
		in1.setSignal(true);
		in2.setSignal(true);
		
		assertFalse(out.getSignal());
	}

	@Test
	public void testIn1FalseIn2False() {
		in1.setSignal(false);
		in2.setSignal(false);
		
		assertFalse(out.getSignal());
	}
	
}
