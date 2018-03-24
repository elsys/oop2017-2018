package org.elsys.gates;

import java.util.ArrayList;
import java.util.List;

public class Wire {

	private List<Gate> gates;
	private boolean state;
	private String name;

	public Wire(String name) {
		this.name = name;
		this.state = false;
		this.gates = new ArrayList<Gate>();
	}

	public String getName() {
		return name;
	}

	public void setSignal(boolean state) {
		if (state != this.state) {
			this.state = state;
			notifyGates();
		}
	}

	public boolean getSignal() {
		return state;
	}

	public void connect(Gate gate) {
		if (!gates.contains(gate)) {
			gates.add(gate);
		}
	}

	private void notifyGates() {
		for (Gate gate : gates) {
			gate.act();
		}
	}
}
