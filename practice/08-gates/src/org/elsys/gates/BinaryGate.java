package org.elsys.gates;

public abstract class BinaryGate extends AbstractGate {
	private Wire in1;
	private Wire in2;
	private Wire out;

	public BinaryGate(Wire in1, Wire in2, Wire out, String name) {
		super(name);
		this.in1 = in1;
		this.in2 = in2;
		this.out = out;

		addInput(in1);
		addInput(in2);
		addOutput(out);
	}
	
	protected Wire getIn1() {
		return in1;
	}
	
	protected Wire getIn2() {
		return in2;
	}
	
	protected Wire getOut() {
		return out;
	}
	
}
