package org.elsys.postfix;

public abstract class UnaryOperation extends AbstractOperation {

	public UnaryOperation(String symbol, Calculator calculator) {
		super(symbol, calculator);
	}

	@Override
	public double execute() {
		double value = getCalculator().popValue();
		return execute(value);
	}

	protected abstract double execute(double value);
}
