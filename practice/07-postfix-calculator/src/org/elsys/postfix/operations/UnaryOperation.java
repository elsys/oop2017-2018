package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public abstract class UnaryOperation extends AbstractOperation {

	public UnaryOperation(Calculator calculator, String token) {
		super(calculator, token);
	}

	@Override
	public void calculate() {
		double value = getCalculator().popValue();
		double result = doCalculate(value);
		getCalculator().addValue(result);		
	}

	protected abstract double doCalculate(double value);
}
