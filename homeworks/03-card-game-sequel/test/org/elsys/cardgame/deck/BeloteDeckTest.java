package org.elsys.cardgame.deck;

import java.util.Arrays;
import java.util.List;

import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.factory.DeckFactory;

import static org.elsys.cardgame.api.Rank.*;

public class BeloteDeckTest extends AbstractDeckTest {

	@Override
	public int deckSize() {
		return 32;
	}

	@Override
	public int handSize() {
		return 8;
	}

	@Override
	public Deck defaultDeck() {
		return DeckFactory.defaultBeloteDeck();
	}

	@Override
	public List<Rank> orderedRanks() {
		return Arrays.asList(SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE);
	}

}
