package org.elsys.gates;

public class NandGate extends BinaryGate implements Gate {

	public NandGate(Wire in1, Wire in2, Wire out, String name) {
		super(in1, in2, out, name);
	}

	public NandGate(Wire in1, Wire in2, Wire out) {
		this(in1, in2, out, "NandGate");
	}

	@Override
	public void act() {
		// TODO Auto-generated method stub
		
	}


}
