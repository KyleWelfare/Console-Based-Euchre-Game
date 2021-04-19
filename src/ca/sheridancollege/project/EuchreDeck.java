package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import ca.sheridancollege.project.Card.Value;
import java.util.ArrayList;

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
                cards.add(new EuchreCard(cardValues[j], cardSuits[i], j + 9));
            }
        }
    }

    public void deal(ArrayList<Player> players) {
        shuffle();

        for (int i = 0; i < players.size(); i++) {
            ((EuchrePlayer)players.get(i)).setHand(new Hand());
            for (int j = 0; j <  ((EuchrePlayer)players.get(i)).getHand().size; j++) {
                ((EuchrePlayer)players.get(i)).getHand().getCards().add(this.cards.get(j));
                this.cards.remove(j);
            }
        }
    }

}
