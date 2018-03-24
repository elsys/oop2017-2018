package org.elsys.gates;

public class XorGate extends BinaryGate implements Gate {

	public XorGate(Wire in1, Wire in2, Wire out, String name) {
		super(in1, in2, out, name);
	}

	public XorGate(Wire in1, Wire in2, Wire out) {
		this(in1, in2, out, "XorGate");
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}


}
