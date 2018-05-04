package org.elsys;

import java.util.Comparator;

public class Proba implements Comparator<Proba>{

	private int val;
	
	public Proba() {
		this.val = -1;
	}
	
	public Proba(int val) {
		this.val = val;
	}
	
	public int getVal() {
		return val;
	}

	@Override
	public int compare(Proba p0, Proba p1) {
		return p0.getVal() - p1.getVal();
	}
}
