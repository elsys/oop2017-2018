package org.elsys.postfix;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Calculator {

	private List<Double> values = new ArrayList<>();
	
	private Map<String, Operation> operations = new HashMap<>();

	private InputStream in;

	private OutputStream out;
	
	public Calculator(InputStream in, OutputStream out) {
		this.in = in;
		this.out = out;
	}

	public void run() {
		Scanner scanner = new Scanner(in);
		PrintStream output = new PrintStream(out);
		while (true) {
			output.printf("(%d): ", values.size());
			String line = scanner.nextLine();
			Operation operation = getOperation(line);
			double value;
			if (operation != null) {
				value = operation.execute();
				output.println(value);
			} else {
				try {
					value = Double.valueOf(line);
				} catch (NumberFormatException e) {
					output.println("Unknown operation");
					continue;
				}
			}
			values.add(value);
		}
	}

	public void addOperation(Operation operation) {
		operations.put(operation.getSymbol(), operation);
	}
	
	public Operation getOperation(String symbol) {
		return operations.get(symbol);
	}

	public double popValue() {
		return values.remove(values.size() - 1);
	}

}
