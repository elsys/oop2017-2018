package org.elsys.gates;

public class AndGate extends BinaryGate implements Gate {

	public AndGate(Wire in1, Wire in2, Wire out, String name) {
		super(in1, in2, out, name);
	}

	public AndGate(Wire in1, Wire in2, Wire out) {
		this(in1, in2, out, "AndGate");
	}

	@Override
	public void act() {
		getOut().setSignal(getIn1().getSignal() && getIn2().getSignal());
	}

}
