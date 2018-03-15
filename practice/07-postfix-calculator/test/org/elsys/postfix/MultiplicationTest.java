package org.elsys.postfix;

import java.util.EmptyStackException;

import org.junit.Test;

public class MultiplicationTest extends CalculatorAbstractTest {

	@Test(expected = EmptyStackException.class)
	public void testWithNotEnoughValuesInStack() {
		input("11");
		input("*");
		inputCtrlC();
		runCalculator();
	}

	@Test
	public void test() {
		input("11");
		input("11");
		input("*");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(121);
		assertCalculatorStackSize(1);
	}
}
