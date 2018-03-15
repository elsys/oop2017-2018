package org.elsys.postfix;

public abstract class AbstractOperation implements Operation {

	private String symbol;
	
	private Calculator calculator;
	
	public AbstractOperation(String symbol, Calculator calculator) {
		this.symbol = symbol;
		this.calculator = calculator;
	}

	@Override
	public Calculator getCalculator() {
		return calculator;
	}

	@Override
	public String getSymbol() {
		return symbol;
	}
	
}
