package org.elsys.gates;

import java.util.ArrayList;
import java.util.List;

public class Wire {

	private boolean state;
	private List<Gate> gates = new ArrayList<Gate>();

	public void setSignal(boolean state) {
		if (state != this.state) {
			this.state = state;
			for (Gate gate : gates) {
				gate.act();
			}
		}
	}

	public boolean getSignal() {
		return state;
	}

	public void connect(Gate gate) {
		if (!gates.contains(gate)) {
			gates.add(gate);
			// gate.act();
		}
	}
}
