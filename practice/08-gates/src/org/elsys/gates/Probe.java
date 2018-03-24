package org.elsys.gates;

import java.io.PrintStream;

public class Probe extends AbstractGate {
	private Wire input;
	private PrintStream printer;

	public Probe(Wire wire, PrintStream printer) {
		super("probe");
		addInput(wire);
		input = wire;
		this.printer = printer;
		this.printer.println("attached to wire <" + input.getName()
				+ ">; initial state: <" + input.getSignal() + ">");
	}

	public Probe(Wire wire) {
		this(wire, System.out);
	}

	@Override
	public void act() {
		printer.println("wire <" + input.getName() + "> state changed to <"
				+ input.getSignal() + ">");
	}

}
