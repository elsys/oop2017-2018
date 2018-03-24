package org.elsys.gates;

public class OrGate extends BinaryGate implements Gate {

	public OrGate(Wire in1, Wire in2, Wire out, String name) {
		super(in1, in2, out, name);
	}

	public OrGate(Wire in1, Wire in2, Wire out) {
		this(in1, in2, out, "OrGate");
	}

	@Override
	public void act() {
		getOut().setSignal(getIn1().getSignal() || getIn2().getSignal());
	}

}
