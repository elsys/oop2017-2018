package org.elsys.gates;

import java.util.ArrayList;
import java.util.List;

public class CompositeGate extends AbstractGate implements Gate {

	private List<Gate> gates = new ArrayList<Gate>();
	
	public CompositeGate(String name) {
		super(name);
	}
	
	public void addGate(Gate gate) {
		if(!gates.contains(gate)) {
			gates.add(gate);
		}
	}
	
	@Override
	public void act() {
		for(Gate gate: gates) {
			gate.act();
		}
	}
}
