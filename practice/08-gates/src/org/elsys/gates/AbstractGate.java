package org.elsys.gates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractGate implements Gate {

	private final String name;
	private List<Wire> inputs = new ArrayList<Wire>();
	private List<Wire> outputs = new ArrayList<Wire>();

	public AbstractGate(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void addInput(Wire input) {
		if (!inputs.contains(input)) {
			inputs.add(input);
			input.connect(this);
		}
	}

	public void addOutput(Wire output) {
		if (!outputs.contains(output)) {
			outputs.add(output);
		}
	}

	public List<Wire> getInputs() {
		return Collections.unmodifiableList(inputs);
	}

	public List<Wire> getOutputs() {
		return Collections.unmodifiableList(outputs);
	}
}
