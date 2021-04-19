package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import java.util.ArrayList;
import java.util.Scanner;

public class EuchreTrick {    
    private EuchreRound currRound;
    private Suit leadSuit = null;
    
    public EuchreTrick(EuchreRound currRound) {
        this.currRound = currRound;
    }
    
    public void promptUser(ArrayList<Player> players, int playerIndex) {
        System.out.println("Trump Suit: " + currRound.getTrumpSuit());
        if (this.leadSuit != null)
            System.out.println("Leading Suit: " + this.leadSuit);
        
        if (currRound.getCardsPlayed().getCards() != null)
            System.out.println("Cards played this trick: " + currRound.getCardsPlayed().toString());
        
        System.out.println("Your Hand: ");
        ((EuchrePlayer) players.get(playerIndex)).getHand().toString();

    }
    
    public void setWeightedValues(ArrayList<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            ArrayList<Card> cards = ((EuchrePlayer)players.get(i)).getHand().getCards();
            for (int j = 0; j < ((EuchrePlayer)players.get(i)).getHand().size; j++) {
                if (cards.get(j).getSuit() == leadSuit && cards.get(j).getSuit() != currRound.getTrumpSuit() && !(cards.get(j).equals(currRound.getRightBower())) && !(cards.get(j).equals(currRound.getLeftBower()))) {
                    ((EuchreCard)((EuchrePlayer)players.get(i)).getHand().getCards().get(j)).setWeightedValue(50);
                }                
            }       
        }
    }
}