package org.elsys.postfix;

import java.util.EmptyStackException;

import org.junit.Test;

public class MinusTest extends CalculatorAbstractTest {

	@Test(expected = EmptyStackException.class)
	public void testWithNotEnoughValuesInStack() {
		input("11");
		input("-");
		inputCtrlC();
		runCalculator();
	}

	@Test
	public void test() {
		input("10");
		input("11");
		input("-");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(-1);
		assertCalculatorStackSize(1);
	}

	@Test
	public void testDoublePlus() {
		input("10");
		input("11");
		input("12");
		input("-");
		input("-");
		inputCtrlC();
		runCalculator();
		assertCalculatorLastValue(11);
		assertCalculatorStackSize(1);
	}
}
