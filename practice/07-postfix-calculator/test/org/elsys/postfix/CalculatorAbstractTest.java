package org.elsys.postfix;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PrintStream;

import org.junit.Before;

public class CalculatorAbstractTest {

	private Calculator calculator;
	private PipedOutputStream inSrc;
	private ByteArrayOutputStream out;

	@Before
	public void beforeEach() throws IOException {
		inSrc = new PipedOutputStream();
		out = new ByteArrayOutputStream();
		calculator = new Calculator(new PipedInputStream(inSrc), new PrintStream(out));
	}
	
	protected Calculator getCalculator() {
		return calculator;
	}

	protected void input(String value) {
		try {
			inSrc.write(value.getBytes());
			inSrc.write("\n".getBytes());
			inSrc.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void inputCtrlC() {
		try {
			inSrc.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected void runCalculator() {
		calculator.run();
	}

	protected void assertOutput(String value) {
		assertEquals(value, out.toString());
	}

	protected void assertCalculatorLastValue(double value) {
		assertEquals(value, calculator.lastValue(), 0.0001);
	}

	protected void assertCalculatorStackSize(int count) {
		assertEquals(count, calculator.stackSize());
	}
}
