package org.elsys.cardgame.game;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.elsys.cardgame.api.Card;
import org.elsys.cardgame.api.CardException;
import org.elsys.cardgame.api.Deck;
import org.elsys.cardgame.api.Game;
import org.junit.Before;
import org.junit.Test;

public abstract class AbstractGameTest {

	private Game game;

	private List<Card> clearDeck;

	protected abstract Game createGame(List<Card> cards);

	public abstract Deck defaultDeck();

	public abstract int deckSize();

	public abstract int handSize();

    @Before
	public void before() {
		Deck deck = defaultDeck();
		deck.shuffle();
		clearDeck = deck.getCards();
		game = createGame(new ArrayList<>(clearDeck));
	}

	@Test
	public void testDeal() {
		game.process("deal");
		assertNotNull(game.getDealtHand());
		assertEquals(deckSize() - handSize(), game.getDeck().size());
		List<Card> cards = game.getDealtHand().getCards();
		assertEquals(clearDeck.subList(0, handSize()), cards);

		game.process("deal");
		assertEquals(deckSize() - handSize() * 2, game.getDeck().size());
		List<Card> handCards = game.getDealtHand().getCards();
		assertEquals(clearDeck.subList(handSize(), handSize() * 2), handCards);
	}

	@Test(expected = CardException.class)
	public void testMoreDealsThanPossible() {
		for (int i = deckSize() / handSize(); i >= 0; i--) {
			game.process("deal");
		}
	}

	@Test
	public void testShuffle() {
		assertEquals(clearDeck, game.getDeck().getCards());
		game.process("shuffle");
		assertNotEquals(clearDeck, game.getDeck().getCards());
	}

	@Test
	public void testSort() {
		game.process("shuffle");
		game.process("sort");
		assertEquals(defaultDeck().getCards(), game.getDeck().getCards());
	}

	@Test
	public void testTopCard() {
		Card topCard = game.getDeck().topCard();
		game.process("top_card");
		Card expectedTopCard = clearDeck.get(0);
		assertEquals(topCard, expectedTopCard);
	}

	@Test
	public void testDrawTopCard() {
		Card topCard = game.getDeck().topCard();
		game.process("draw_top_card");
		Card newTopCard = game.getDeck().topCard();
		assertNotEquals(newTopCard, topCard);
		game.process("draw_top_card");
		assertNotEquals(newTopCard, game.getDeck().topCard());
	}

	@Test
	public void testBottomCard() {
		Card bottomCard = game.getDeck().bottomCard();
		Card expectedBottomCard = clearDeck.get(clearDeck.size() - 1);
		assertEquals(bottomCard, expectedBottomCard);
		game.process("bottom_card");
	}

	@Test
	public void testDrawBottomCard() {
		Card bottomCard = game.getDeck().bottomCard();
		game.process("draw_bottom_card");
		Card newBottomCard = game.getDeck().bottomCard();
		assertNotEquals(newBottomCard, bottomCard);
		game.process("draw_bottom_card");
		assertNotEquals(newBottomCard, game.getDeck().bottomCard());
	}

	@Test(expected = CardException.class)
	public void testTooMuchDrawTopCard() {
		for (int i = 0; i <= deckSize(); i++) {
			game.process("draw_top_card");
		}
	}

	@Test(expected = CardException.class)
	public void testTooMuchDrawBottomCard() {
		for (int i = 0; i <= deckSize(); i++) {
			game.process("draw_bottom_card");
		}
	}
}
