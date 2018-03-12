package org.elsys.postfix;

public class MainClass {

	public static void main(String[] args) {
		Calculator calculator = new Calculator(System.in, System.out);
		calculator.addOperation(new Negate(calculator));
		calculator.addOperation(new Square(calculator));
		calculator.run();
	}

}
