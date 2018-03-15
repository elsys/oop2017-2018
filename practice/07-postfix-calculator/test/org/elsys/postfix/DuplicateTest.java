package org.elsys.postfix;

import org.junit.Test;

public class DuplicateTest extends CalculatorAbstractTest {

	@Test
	public void test() {
		input("10");
		input("dup");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(10);
		assertCalculatorStackSize(2);
	}

	@Test
	public void testDuplicateAndNegate() {
		input("10");
		input("dup");
		input("neg");
		input("dup");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(-10);
		assertCalculatorStackSize(3);
	}
}
