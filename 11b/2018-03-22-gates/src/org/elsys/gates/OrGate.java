package org.elsys.gates;

public class OrGate extends BinaryGate {

	public OrGate(Wire in1, Wire in2, Wire out) {
		super(in1, in2, out);
	}

	@Override
	public void act() {
		getOut().setSignal(
				getIn1().getSignal() || getIn2().getSignal());
	}

}
