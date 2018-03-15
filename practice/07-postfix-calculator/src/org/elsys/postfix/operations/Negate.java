package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Negate extends UnaryOperation implements Operation {

	public Negate(Calculator calculator) {
		super(calculator, "neg");
	}
	
	@Override
	protected double doCalculate(double value) {
		return -value;
	}

}
