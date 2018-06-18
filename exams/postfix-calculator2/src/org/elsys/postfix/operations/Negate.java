package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public class Negate extends AbstractOperation implements Operation {

	public Negate(Calculator calculator) {
		super(calculator, "neg");
	}

	@Override
	public void calculate() {
		Double value = getCalculator().popValue();
		double result = -value;
		getCalculator().addValue(result);
	}

}
