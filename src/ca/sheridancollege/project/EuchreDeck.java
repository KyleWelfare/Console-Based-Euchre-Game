package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import ca.sheridancollege.project.Card.Value;

public class EuchreDeck extends GroupOfCards {

    private static EuchreDeck instance = null; // this is our one global Object
    private final static int DECK_SIZE = 24;

    public EuchreDeck(int size) {
        super(size);
    }

    public static EuchreDeck getInstance() {
        if (instance == null) {
            instance = new EuchreDeck(DECK_SIZE);
        }
        return instance;
    }

    public void resetDeck(Value[] cardValues, Suit[] cardSuits) {
        if (this.cards != null) {
            cards.clear();
        }
        for (int i = 0; i < cardSuits.length; i++) {
            for (int j = 0; j < cardValues.length; j++) {
                cards.add(new EuchreCard(cardValues[j], cardSuits[i], j + 1));
            }
        }
    }

    public void deal(EuchrePlayer[] players, int handSize) {
        shuffle();

        for (int i = 0; i < players.length; i++) {
            players[i].setHand(new Hand(handSize));
            for (int j = 0; j < players[i].getHand().size; j++) {
                players[i].getHand().getCards().add(this.cards.get(j));
                this.cards.remove(j);
            }
        }
    }

}
