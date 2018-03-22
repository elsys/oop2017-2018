package org.elsys.gates;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractGate implements Gate {
	
	private List<Wire> inputs = new ArrayList<Wire>();
	private List<Wire> outputs = new ArrayList<Wire>();

	@Override
	public List<Wire> getOutputs() {
		return Collections.unmodifiableList(outputs);
	}
	
	@Override
	public List<Wire> getInputs() {
		return Collections.unmodifiableList(inputs);
	}
	
	public void addOutput(Wire output) {
		if(!outputs.contains(output)) {
			outputs.add(output);
		}
	}
	
	public void addInput(Wire input) {
		if(!inputs.contains(input)) {
			inputs.add(input);
			input.connect(this);
		}
	}
}
