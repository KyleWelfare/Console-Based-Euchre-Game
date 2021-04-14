package ca.sheridancollege.project;

import ca.sheridancollege.project.Card.Suit;
import ca.sheridancollege.project.Card.Value;
import java.util.Scanner;

public class EuchreGame extends Game {
    public static void main (String[] args) {
        
        //testing/debugging - you can get rid of all this
        Value[] cardValues = Value.values();
        Suit[] cardSuits = Suit.values();
        final int NUM_PLAYERS = 4;
        final int HAND_SIZE = 5;
        
        EuchrePlayer[] players = new EuchrePlayer[NUM_PLAYERS];
        for (int i = 0; i<players.length; i++) {
            Scanner input = new Scanner(System.in);
            System.out.println("Enter a name for Player " + (i+1) + ":");
            String name = input.nextLine();
            players[i] = new EuchrePlayer(name);
        }
        //Hand[] hands = new Hand[NUM_PLAYERS];
        
        EuchreDeck.getInstance().resetDeck(cardValues, cardSuits);
        System.out.println(EuchreDeck.getInstance().toString());

        EuchreDeck.getInstance().deal(players, HAND_SIZE);
       
        for (EuchrePlayer player : players) {
            System.out.println(player.getHand().toString());
        }
        
        System.out.println(EuchreDeck.getInstance().toString());
    }    
    
    public EuchreGame () {
        super("Euchre Game #");
    }
    
    @Override
    public void play() {
      
    }

    @Override
    public void declareWinner() {
        
    }
}