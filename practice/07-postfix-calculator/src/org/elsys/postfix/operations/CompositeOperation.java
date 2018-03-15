package org.elsys.postfix.operations;

import java.util.ArrayList;
import java.util.List;

import org.elsys.postfix.Calculator;

public class CompositeOperation extends AbstractOperation {

	private List<Operation> operations = new ArrayList<Operation>();
	
	public CompositeOperation(Calculator calculator, String token) {
		super(calculator, token);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void calculate() {
		// TODO Auto-generated method stub
		
	}
	
	public void addOperation(Operation op) {
		// TODO:
	}

}
