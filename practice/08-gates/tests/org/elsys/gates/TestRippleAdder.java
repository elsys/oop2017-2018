package org.elsys.gates;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestRippleAdder {

	private Wire a[];
	private Wire b[];
	private Wire cIn;
	private Wire sum[];
	private Wire cOut;

	private Gate adder;

	private static final int COUNT = 4;

	@Before
	public void beforeEach() {
		a = new Wire[COUNT];
		b = new Wire[COUNT];
		sum = new Wire[COUNT];

		for (int i = 0; i < COUNT; ++i) {
			a[i] = new Wire("a" + i);
			b[i] = new Wire("b" + i);
			sum[i] = new Wire("sum" + i);
		}
		cIn = new Wire("Cin");
		cOut = new Wire("Cout");

		adder = GateFactory.makeRippleCarryAdder(a, b, cIn, sum, cOut);
		assertNotNull(adder);
	}

	public static void intToWires(int val, Wire[] w) {
		for (int i = 0; i < w.length; ++i) {
			int bit = 1 << i;
			w[i].setSignal((bit & val) != 0);
		}
	}

	public static int wiresToInt(Wire[] w) {
		int result = 0;
		for (int i = 0; i < w.length; ++i) {
			if (w[i].getSignal()) {
				int bit = 1 << i;
				result = result | bit;
			}
		}
		return result;
	}

	@Test
	public void test() {
		int res = 0;

		intToWires(1, a);
		res = wiresToInt(a);
		assertEquals(1, res);

		intToWires(2, a);
		res = wiresToInt(a);
		assertEquals(2, res);

		intToWires(3, a);
		res = wiresToInt(a);
		assertEquals(3, res);

	}

	@Test
	public void testAdderOnePlusOne() {
		intToWires(1, a);
		intToWires(1, b);

		int res = wiresToInt(sum);
		assertEquals(2, res);
		assertFalse(cOut.getSignal());
	}

	@Test
	public void testAdder5Plus5() {
		intToWires(5, a);
		intToWires(5, b);

		int res = wiresToInt(sum);
		assertEquals(10, res);
		assertFalse(cOut.getSignal());
	}

	@Test
	public void testAdder8Plus8() {
		intToWires(8, a);
		intToWires(8, b);

		int res = wiresToInt(sum);
		assertEquals(0, res);
		assertTrue(cOut.getSignal());
	}

	@Test
	public void testAdder9Plus9() {
		intToWires(9, a);
		intToWires(9, b);

		int res = wiresToInt(sum);
		assertEquals(2, res);
		assertTrue(cOut.getSignal());
	}	
}
