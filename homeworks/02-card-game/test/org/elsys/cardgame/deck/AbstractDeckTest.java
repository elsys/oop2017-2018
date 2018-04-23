
package org.elsys.cardgame.deck;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collections;
import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Hand;
import org.elsys.cardgame.api.Rank;
import org.elsys.cardgame.api.Suit;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractDeckTest {

	private Deck deck;

	private Deck clearDeck;

	public abstract int deckSize();

	public abstract int handSize();

	public abstract Deck defaultDeck();

	public abstract List<Rank> orderedRanks();

	@Before
	public void before() {
		deck = defaultDeck();
		clearDeck = defaultDeck();
	}

	@Test
	public void testSize() {
		assertEquals(deckSize(), deck.size());
	}

	@Test
	public void testDeal() {
		Hand hand = deck.deal();
		assertEquals("Hand size is incorrect", handSize(), hand.size());
		assertEquals("New size of deck is incorrect", deckSize() - handSize(), deck.size());

		clearDeck.getCards().removeAll(hand.getCards());
		assertTrue("Cards left in deck are incorrect", clearDeck.getCards().equals(deck.getCards()));
		Collections.reverse(hand.getCards());
		deck.getCards().addAll(hand.getCards());
		assertTrue("Cards left in hand are incorrect", defaultDeck().getCards().equals(deck.getCards()));
	}

	@Test
	public void testShuffle() {
		deck.shuffle();
		assertNotEquals("Shuffle doesn't works", clearDeck.getCards(), deck.getCards());
	}

	@Test
	public void testSort() {
		deck.shuffle();
		deck.sort();
		assertEquals("Sort works correctly", clearDeck.getCards(), deck.getCards());
	}

	@Test
	public void testDrawTopCard() {
		Card card = deck.drawTopCard();
		assertEquals("Deck size is incorrect", deckSize() - 1, deck.size());
		assertEquals("Card rank is incorrect", orderedRanks().get(0), card.getRank());
		assertEquals("Card suit is incorrect", Suit.CLUBS, card.getSuit());
	}

	@Test
	public void testTopCard() {
		Card card = deck.topCard();
		assertEquals("Deck size is incorrect", deckSize(), deck.size());
		assertEquals("Card is incorrect", orderedRanks().get(0), card.getRank());
		assertEquals("Card suit is incorrect", Suit.CLUBS, card.getSuit());
	}

	@Test
	public void testDrawBottomCard() {
		Card card = deck.drawBottomCard();
		assertEquals("Deck size is correct", deckSize() - 1, deck.size());
		List<Rank> ranks = orderedRanks();
		assertEquals("Card is correct", ranks.get(ranks.size() - 1), card.getRank());
		assertEquals("Card suit is correct", Suit.SPADES, card.getSuit());
	}

	@Test
	public void testBottomCard() {
		Card card = deck.bottomCard();
		assertEquals("Deck size is incorrect", deckSize(), deck.size());
		List<Rank> ranks = orderedRanks();
		assertEquals("Card is incorrect", ranks.get(ranks.size() - 1), card.getRank());
		assertEquals("Card suit is incorrect", Suit.SPADES, card.getSuit());
	}

}
