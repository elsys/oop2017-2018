package org.elsys.gates;

public abstract class GateFactory {

	public Gate makeXor(Wire in1, Wire in2, Wire out) {
		CompositeGate result = new CompositeGate();
		result.addInput(in1);
		result.addInput(in2);
		result.addOutput(out);
		
		Wire a = new Wire();
		Wire b = new Wire();
		Wire c = new Wire();
		
		Gate orGate = new OrGate(in1, in2, a);
		Gate andGate1 = new AndGate(in1, in2, b);
		Gate notGate = new InverterGate(b, c);
		Gate andGate2 = new AndGate(a, c, out);
		
		result.addGate(orGate);
		result.addGate(andGate1);
		result.addGate(notGate);
		result.addGate(andGate2);
		
		return result;
	}
}
