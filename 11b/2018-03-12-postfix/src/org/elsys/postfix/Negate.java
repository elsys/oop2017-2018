package org.elsys.postfix;

public class Negate extends UnaryOperation {

	public Negate(Calculator calculator) {
		super("neg", calculator);
	}

	@Override
	public double execute(double value) {
		return -value;
	}

}
