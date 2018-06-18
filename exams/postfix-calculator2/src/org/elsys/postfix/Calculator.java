package org.elsys.postfix;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.elsys.postfix.operations.Negate;
import org.elsys.postfix.operations.Operation;

public class Calculator {

	private Map<String, Operation> operations = new HashMap<>();

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

	}

	/**
	 * Checks if the given string is a valid double number.
	 * @param input
	 * @return
	 */
	private static boolean isDouble(String input) {
		try {
			Double.valueOf(input);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Adds the given operation to the calculator.
	 * @param operation
	 */
	public void addOperation(Operation operation) {
		operations.put(operation.getToken(), operation);
	}

	/**
	 * Returns the corresponding operation to the provided token.
	 * @param token
	 * @return
	 */
	public Operation getOperation(String token) {
		return operations.get(token);
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
