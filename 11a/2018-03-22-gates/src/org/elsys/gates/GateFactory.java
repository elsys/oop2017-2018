package org.elsys.gates;

public abstract class GateFactory {

	public static Gate makeXor(Wire in1, Wire in2, Wire out) {
		CompositeGate gate = new CompositeGate();
		gate.addInput(in1);
		gate.addInput(in2);
		gate.addOutput(out);
		
		Wire a = new Wire();
		Wire b = new Wire();
		Wire c = new Wire();
		
		Gate orGate = new OrGate(in1, in2, a);
		Gate andGate = new AndGate(in1, in2, b);
		Gate notGate = new InverterGate(b, c);
		Gate andGate1 = new AndGate(a,c, out);

		gate.addGate(orGate);
		gate.addGate(andGate);
		gate.addGate(notGate);
		gate.addGate(andGate1);
		
		return gate;
	}
}
