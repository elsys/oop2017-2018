package org.elsys.postfix;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.elsys.postfix.operations.Negate;
import org.elsys.postfix.operations.Operation;

public class Calculator {

	private InputStream in;

	private PrintStream out;
	
	public Calculator(InputStream in, PrintStream out) {
		this.in = in;
		this.out = out;
		addOperation(new Negate(this));
	}

	/**
	 * 
	 */
	public void run() {
		String input;
		try (Scanner scanner = new Scanner(in)) {
			while (scanner.hasNext()) {
				out.print(stackSize() + ": ");
				input = scanner.next();
				if (isDouble(input)) {
					addValue(Double.valueOf(input));
				} else {
					Operation operation = getOperation(input);
					if (operation != null) {
						operation.calculate();
					} else {
						throw new UnsupportedOperationException();
					}
				}
			}
		}
	}

	/**
	 * Checks if the given string is a valid double number.
	 * @param input
	 * @return
	 */
	private static boolean isDouble(String input) {
		return false;
	}

	/**
	 * Adds the given operation to the calculator.
	 * @param operation
	 */
	public void addOperation(Operation operation) {
		
	}

	/**
	 * Returns the corresponding operation to the provided token.
	 * @param token
	 * @return
	 */
	public Operation getOperation(String token) {
		return null;
	}

	/**
	 * Removes the top value from the calculator stack and returns it as result.
	 * 
	 * @return
	 */
	public Double popValue() {
		return null;
	}

	/**
	 * Adds the provided value to the calculator stack.
	 * @param value
	 */
	public void addValue(double value) {
		
	}

	/**
	 * Returns the size of the calculator stack.
	 * @return
	 */
	public int stackSize() {
		return 0;
	}
}
