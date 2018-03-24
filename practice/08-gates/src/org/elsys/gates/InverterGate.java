package org.elsys.gates;

public class InverterGate extends AbstractGate implements Gate {

	private Wire in;
	private Wire out;

	public InverterGate(Wire in, Wire out, String name) {
		super(name);
		this.in = in;
		this.out = out;
	}

	public InverterGate(Wire in, Wire out) {
		this(in, out, "InverterGate");
	}

	@Override
	public void act() {
		out.setSignal(!in.getSignal());
	}
}
