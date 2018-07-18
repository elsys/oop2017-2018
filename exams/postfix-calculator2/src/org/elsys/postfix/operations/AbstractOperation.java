package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public abstract class AbstractOperation implements Operation {

	private Calculator calculator;

	private String token;

	public AbstractOperation(Calculator calculator, String token) {
		this.calculator = calculator;
		this.token = token;
	}
	
	@Override
	public Calculator getCalculator() {
		return calculator;
	}

	@Override
	public String getToken() {
		return token;
	}

}
