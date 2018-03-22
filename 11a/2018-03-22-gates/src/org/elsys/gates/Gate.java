package org.elsys.gates;

import java.util.List;

public interface Gate {

	public void act();
	
	public List<Wire> getInputs();
	public List<Wire> getOutputs();
}
