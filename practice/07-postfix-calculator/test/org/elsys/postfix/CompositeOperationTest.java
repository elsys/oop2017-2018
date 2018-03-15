package org.elsys.postfix;

import org.elsys.postfix.operations.CompositeOperation;
import org.junit.Test;

public class CompositeOperationTest extends CalculatorAbstractTest {

	@Test
	public void testSimpleNegate() {
		getCalculator().addValue(10.0);
		CompositeOperation composite = new CompositeOperation(getCalculator(), "compositeTest");
		composite.addOperation(getCalculator().getOperation("neg"));

		composite.calculate();

		assertCalculatorLastValue(-10.0);
	}

	@Test
	public void testSimpleComposite() {
		getCalculator().addValue(3.0);
		getCalculator().addValue(4.0);
		
		CompositeOperation composite = new CompositeOperation(getCalculator(), "compositeTest");
		composite.addOperation(getCalculator().getOperation("+"));
		composite.addOperation(getCalculator().getOperation("dup"));
		composite.addOperation(getCalculator().getOperation("*"));
		composite.calculate();

		assertCalculatorLastValue(49.0);
		
	}
}
