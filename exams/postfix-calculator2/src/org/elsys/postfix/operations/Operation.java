package org.elsys.postfix.operations;

import org.elsys.postfix.Calculator;

public interface Operation {

	void calculate();
	
	Calculator getCalculator();
	
	String getToken();
}
