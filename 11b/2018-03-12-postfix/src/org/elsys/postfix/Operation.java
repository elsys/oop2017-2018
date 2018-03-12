package org.elsys.postfix;

public interface Operation {

	String getSymbol();
	
	double execute();
	
	Calculator getCalculator();
}
