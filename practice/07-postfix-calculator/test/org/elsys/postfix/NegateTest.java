package org.elsys.postfix;

import org.junit.Test;

public class NegateTest extends CalculatorAbstractTest {

	@Test
	public void test() {
		input("10");
		input("neg");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(-10);
	}

}
