package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import java.util.ArrayList;
import java.util.Scanner;

public class EuchreTrick {
    private Suit trumpSuit;
    private EuchreRound currRound;
    private Suit leadSuit = null;
    
    public EuchreTrick(EuchreRound currRound) {
        this.currRound = currRound;
    }
    
    public void promptUser(ArrayList<Player> players, int playerIndex) {
        System.out.println("Trump Suit: " + currRound.getTrumpSuit());
        if (this.leadSuit != null)
            System.out.println("Lead Suit: " + this.leadSuit);
        
        if (currRound.getCardsPlayed().getCards() != null)
            System.out.println("Cards played this trick: " + currRound.getCardsPlayed().toString());
        
        System.out.println("Your Hand: ");
        ((EuchrePlayer) players.get(playerIndex)).getHand().toString();
        
        System.out.println("Enter the corresponding number to play a card");

    }
}