package org.elsys.cardgame.deck;

import java.util.Arrays;
import java.util.List;

import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.factory.DeckFactory;

import static org.elsys.cardgame.api.Rank.*;

public class SantaseDeckTest extends AbstractDeckTest {

	@Override
	public int deckSize() {
		return 24;
	}

	@Override
	public int handSize() {
		return 6;
	}

	@Override
	public Deck defaultDeck() {
		return DeckFactory.defaultSantaseDeck();
	}

	@Override
	public List<Rank> orderedRanks() {
		return Arrays.asList(NINE, JACK, QUEEN, KING, TEN, ACE);
	}

}
