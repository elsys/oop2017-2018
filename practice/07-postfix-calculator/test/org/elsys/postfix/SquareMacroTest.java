package org.elsys.postfix;

import org.junit.Test;

public class SquareMacroTest extends CalculatorAbstractTest {

	@Test
	public void test() {
		input("\\square");
		input("dup");
		input("*");
		input("dev");
		
		input("2");
		input("square");
		
		runCalculator();
		assertCalculatorLastValue(4.0);
	}

}
