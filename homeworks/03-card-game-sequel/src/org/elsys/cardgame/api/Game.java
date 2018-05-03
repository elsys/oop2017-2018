package org.elsys.cardgame.api;

public interface Game {

	Deck getDeck();
	
	Hand getDealtHand();
	
	void setDealtHand(Hand hand);

	void process(String command);

	void addOperation(Operation operation);
}
