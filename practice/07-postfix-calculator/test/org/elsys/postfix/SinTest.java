package org.elsys.postfix;

import org.junit.Test;

public class SinTest extends CalculatorAbstractTest {

	@Test
	public void test() {
		input("10");
		input("sin");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(Math.sin(10));
	}

}
