package org.elsys.cardgame.api;

import java.util.List;

public interface Hand {

	List<Card> getCards();

	int size();
}
